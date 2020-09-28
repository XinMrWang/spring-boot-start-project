package com.halink.scaffold.core.redis;

import redis.clients.jedis.commands.BinaryJedisCommands;
import redis.clients.jedis.commands.JedisCommands;

/**
 * @author zhuanglunhang
 */
public interface RedisClient extends JedisCommands, BinaryJedisCommands {

}