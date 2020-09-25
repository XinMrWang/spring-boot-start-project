package com.halink.scaffold.common.enumerate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.halink.scaffold.config.enumhandler.CustomEnumDeserializer;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
@JsonDeserialize(using = CustomEnumDeserializer.class)
public interface BaseEnum {
    /**
     * 获得枚举值
     */
    int getValue();
}