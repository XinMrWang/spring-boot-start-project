package com.halink.scaffold.core.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhuanglunhang
 */
@Configuration
public class RedisFactory implements InvocationHandler {

    private final RedisConfig redisConfig;
    private final Map<RedisMethodKey, Method> cacheMap;
    private JedisPool jedisPool;
    private JedisCluster jedisCluster;

    public RedisFactory(RedisConfig redisConfig) {
        cacheMap = new LinkedHashMap<>();
        this.redisConfig = redisConfig;
        int maxAttempts = 3;
        int timeout = 300;
        int connectionTimeout = 300;
        if (StringUtils.isNotBlank(redisConfig.getTimeout())) {
            timeout = Integer.parseInt(redisConfig.getTimeout());
        }
        // 集群版
        if (StringUtils.isNotBlank(redisConfig.getClusterNodes())) {
            Set<HostAndPort> hostAndPorts = Arrays.stream(redisConfig.getClusterNodes().split(","))
                    .map(line -> {
                        String[] split = line.split(":");
                        return new HostAndPort(split[0], Integer.parseInt(split[1]));
                    }).collect(Collectors.toSet());
            if (StringUtils.isNotBlank(redisConfig.getPassword())) {
                jedisCluster = new JedisCluster(hostAndPorts, connectionTimeout, timeout, maxAttempts,
                        redisConfig.getPassword(), new GenericObjectPoolConfig());
            } else {
                jedisCluster = new JedisCluster(hostAndPorts, connectionTimeout, timeout, maxAttempts,
                        new GenericObjectPoolConfig());
            }
        } else {
            jedisPool = new JedisPool(redisConfig.getHost(), Integer.parseInt(redisConfig.getPort()));
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method myMethod = null;
        RedisMethodKey redisMethodKey = new RedisMethodKey(method.getName(),
                method.getParameterTypes());
        if (cacheMap.containsKey(redisMethodKey)) {
            myMethod = cacheMap.get(redisMethodKey);
        }
        if (StringUtils.isNotBlank(redisConfig.getClusterNodes())) {
            if (myMethod == null) {
                myMethod = MethodUtils
                        .getMatchingMethod(jedisCluster.getClass(), method.getName(), method.getParameterTypes());
                cacheMap.put(redisMethodKey, myMethod);
            }
            return myMethod.invoke(jedisCluster, args);
        } else {
            Jedis jedis = jedisPool.getResource();
            if (myMethod == null) {
                myMethod = MethodUtils
                        .getMatchingMethod(jedis.getClass(), method.getName(), method.getParameterTypes());
                cacheMap.put(redisMethodKey, myMethod);
            }
            try {
                return myMethod.invoke(jedis, args);
            } finally {
                jedis.close();
            }
        }
    }

    @Bean(name = "redisClient")
    public RedisClient getRedisClient(RedisConfig redisConfig) {
        return (RedisClient) Proxy
                .newProxyInstance(RedisClient.class.getClassLoader(), new Class[]{RedisClient.class},
                        new RedisFactory(redisConfig));
    }

    @Data
    @AllArgsConstructor
    static class RedisMethodKey {
        private String methodName;
        private Class<?>[] methodType;
    }

}