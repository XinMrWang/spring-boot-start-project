package com.halink.scaffold.core.util;

import com.halink.scaffold.common.enumerate.BaseEnum;

/**
 * CodeEnumUtil
 *
 * @author halink
 */
public class CodeEnumUtil {

    public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getValue() == code) {
                return e;
            }
        }
        return null;
    }
}
