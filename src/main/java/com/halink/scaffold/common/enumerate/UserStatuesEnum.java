package com.halink.scaffold.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态
 *
 * @author halink
 */
@AllArgsConstructor
public enum UserStatuesEnum implements BaseEnum {

    /**
     * 正常
     */
    NORMAL(1);

    @Getter
    private final int value;

    /**
     * 获取枚举名
     */
    @Override
    public String getName() {
        return this.name().toUpperCase();
    }
}
