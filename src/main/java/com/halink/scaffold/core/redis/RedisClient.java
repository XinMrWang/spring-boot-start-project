package com.halink.scaffold.core.redis;

import redis.clients.jedis.commands.BinaryJedisCommands;
import redis.clients.jedis.commands.JedisCommands;

/**
 * @author zhuanglunhang
 * 2020-05-07 14:04
 */
public interface RedisClient extends JedisCommands, BinaryJedisCommands {

}