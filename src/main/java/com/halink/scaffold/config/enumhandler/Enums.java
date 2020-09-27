package com.halink.scaffold.config.enumhandler;

import com.halink.scaffold.common.enumerate.BaseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static com.google.common.collect.Maps.newLinkedHashMap;
import static com.google.common.collect.Maps.newLinkedHashMapWithExpectedSize;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;

@Slf4j
public class Enums {
    /**
     * 获取枚举中指定属性的值
     *
     * @param enumCls 枚举类型
     * @param prop    Bean属性名
     * @return (枚举值, 指定属性的值)
     */
    public static Map<BaseEnum, Object> getEnumAndValue(Class<?> enumCls, String prop) {
        Object[] enumValues = enumCls.getEnumConstants();
        if (isEmpty(enumValues)) {
            return newLinkedHashMap();
        }
        Map<BaseEnum, Object> result = newLinkedHashMapWithExpectedSize(enumValues.length * 2);
        try {
            for (Object enumValue : enumValues) {
                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(enumValue.getClass(), prop);
                if (pd == null || pd.getReadMethod() == null) {
                    continue;
                }
                result.put((BaseEnum) enumValue, pd.getReadMethod().invoke(enumValue));
            }
        } catch (Exception e) {
            // ignore
            log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 匹配枚举集合中指定的Bean属性, 返回该枚举值
     *
     * @param prop      Bean属性名
     * @param propValue Bean属性值
     */
    public static <T extends BaseEnum> Optional<T> getEnum(Class<T> enumCls, String prop, int propValue) {
        T[] enumValues = enumCls.getEnumConstants();
        if (isEmpty(enumValues)) {
            return empty();
        }
        try {
            for (T enumValue : enumValues) {
                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(enumValue.getClass(), prop);
                if (pd == null || pd.getReadMethod() == null) {
                    continue;
                }
                Method m = pd.getReadMethod();
                m.setAccessible(true);
                if (propValue == enumValue.getValue()) {
                    return of(enumValue);
                }
            }
        } catch (Exception e) {
            // ignore
            log.error(e.getMessage(), e);
        }
        return empty();
    }
}
