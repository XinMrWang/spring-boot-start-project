package com.lsc.startproject.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * redis工具类
 *
 * @author halink
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间（秒）
     * @return true / false
     */
    @SuppressWarnings("unchecked")
    public Boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 根据 key 获取过期时间
     *
     * @param key 键
     * @return 获取过期时间
     */
    @SuppressWarnings("unchecked")
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断 key 是否存在
     *
     * @param key 键
     * @return true / false
     */
    @SuppressWarnings("unchecked")
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     *
     * @param key 键（一个或者多个）
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

//    ============================== String ==============================

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     */
    @SuppressWarnings("unchecked")
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间（秒），如果 time < 0 则设置无限时间
     */
    @SuppressWarnings("unchecked")
    public void set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 递增大小
     */
    @SuppressWarnings("unchecked")
    public Long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于 0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 递减大小
     */
    @SuppressWarnings("unchecked")
    public Long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于 0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

//    ============================== Map ==============================

    /**
     * HashGet
     *
     * @param key  键（no null）
     * @param item 项（no null）
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取 key 对应的 map
     *
     * @param key 键（no null）
     * @return 对应的多个键值
     */
    @SuppressWarnings("unchecked")
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 值
     */
    @SuppressWarnings("unchecked")
    public void hmset(String key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  值
     * @param time 时间
     */
    @SuppressWarnings("unchecked")
    public void hmset(String key, Map<Object, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 向一张 Hash表 中放入数据，如不存在则创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     */
    @SuppressWarnings("unchecked")
    public void hset(String key, String item, Object value) {
        redisTemplate.opsForHash().put(key, item, value);
    }

    /**
     * 向一张 Hash表 中放入数据，并设置时间，如不存在则创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间（如果原来的 Hash表 设置了时间，这里会覆盖）
     */
    @SuppressWarnings("unchecked")
    public void hset(String key, String item, Object value, long time) {
        redisTemplate.opsForHash().put(key, item, value);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 删除 Hash表 中的值
     *
     * @param key  键
     * @param item 项（可以多个，no null）
     */
    @SuppressWarnings("unchecked")
    public Long hdel(String key, Object... item) {
        return redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断 Hash表 中是否有该键的值
     *
     * @param key  键（no null）
     * @param item 值（no null）
     * @return true / false
     */
    @SuppressWarnings("unchecked")
    public Boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * Hash递增，如果不存在则创建一个，并把新增的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   递增大小 > 0
     */
    @SuppressWarnings("unchecked")
    public Double hincr(String key, String item, Double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * Hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   递减大小
     */
    @SuppressWarnings("unchecked")
    public Double hdecr(String key, String item, Double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

//    ============================== Set ==============================

    /**
     * 根据 key 获取 set 中的所有值
     *
     * @param key 键
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 从键为 key 的 set 中，根据 value 查询是否存在
     *
     * @param key   键
     * @param value 值
     * @return true / false
     */
    @SuppressWarnings("unchecked")
    public Boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 将数据放入 set缓存
     *
     * @param key    键值
     * @param values 值（可以多个）
     * @return 成功个数
     */
    @SuppressWarnings("unchecked")
    public Long sSet(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 将数据放入 set缓存，并设置时间
     *
     * @param key    键
     * @param time   时间
     * @param values 值（可以多个）
     * @return 成功放入个数
     */
    @SuppressWarnings("unchecked")
    public Long sSet(String key, long time, Object... values) {
        Long count = redisTemplate.opsForSet().add(key, values);
        if (time > 0) {
            expire(key, time);
        }
        return count;
    }

    /**
     * 获取 set缓存的长度
     *
     * @param key 键
     * @return 长度
     */
    @SuppressWarnings("unchecked")
    public Long sGetSetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 移除 set缓存中，值为 value 的
     *
     * @param key    键
     * @param values 值
     * @return 成功移除个数
     */
    @SuppressWarnings("unchecked")
    public Long setRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

//    ============================== List ==============================

    /**
     * 获取 list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束（0 到 -1 代表所有值）
     */
    @SuppressWarnings("unchecked")
    public List<Object> lGet(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取 list缓存的长度
     *
     * @param key 键
     * @return 长度
     */
    @SuppressWarnings("unchecked")
    public Long lGetListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 根据索引 index 获取键为 key 的 list 中的元素
     *
     * @param key   键
     * @param index 索引
     *              当 index >= 0 时 {0:表头, 1:第二个元素}
     *              当 index < 0 时 {-1:表尾, -2:倒数第二个元素}
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public Object lGetIndex(String key, Long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 将值 value 插入键为 key 的 list 中，如果 list 不存在则创建空 list
     *
     * @param key   键
     * @param value 值
     * @return true / false
     */
    @SuppressWarnings("unchecked")
    public Long lSet(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 将值 value 插入键为 key 的 list 中，并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间
     */
    @SuppressWarnings("unchecked")
    public void lSet(String key, Object value, long time) {
        redisTemplate.opsForList().rightPush(key, value);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 将 values 插入键为 key 的 list 中
     *
     * @param key    键
     * @param values 值
     * @return true / false
     */
    @SuppressWarnings("unchecked")
    public Long lSetList(String key, List<Object> values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 将 values 插入键为 key 的 list 中，并设置时间
     *
     * @param key    键
     * @param values 值
     * @param time   时间
     */
    @SuppressWarnings("unchecked")
    public void lSetList(String key, List<Object> values, long time) {
        redisTemplate.opsForList().rightPushAll(key, values);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 根据索引 index 修改键为 key 的值
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     */
    @SuppressWarnings("unchecked")
    public void lUpdateIndex(String key, long index, Object value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 在键为 key 的 list 中删除值为 value 的元素
     *
     * @param key   键
     * @param count 如果 count == 0 则删除 list 中所有值为 value 的元素
     *              如果 count > 0 则删除 list 中最左边那个值为 value 的元素
     *              如果 count < 0 则删除 list 中最右边那个值为 value 的元素
     */
    @SuppressWarnings("unchecked")
    public Long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }

}