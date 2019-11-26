package com.lsc.startproject.core.util;

import com.lsc.startproject.common.enumerate.BaseEnum;

/**
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
