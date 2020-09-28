package com.halink.scaffold.core.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuanglunhang
 */
@Data
@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;
    @Value("${redis.timeout}")
    private String timeout;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.clusterNodes}")
    private String clusterNodes;
}