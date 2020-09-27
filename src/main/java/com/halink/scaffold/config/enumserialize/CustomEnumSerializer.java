package com.halink.scaffold.config.enumserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.halink.scaffold.common.enumerate.BaseEnum;

import java.io.IOException;

/**
 * 序列化
 *
 * @author LiKeshuang
 * @date 2020/9/27 5:16 下午
 */
public class CustomEnumSerializer extends JsonSerializer<BaseEnum> {

    /**
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(BaseEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getName());
    }
}
