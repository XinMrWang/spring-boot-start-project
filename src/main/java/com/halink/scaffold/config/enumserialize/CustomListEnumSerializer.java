package com.halink.scaffold.config.enumserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.Lists;
import com.halink.scaffold.common.enumerate.BaseEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数组序列化
 *
 * @author halink
 * @date 2020/9/27 5:16 下午
 */
public class CustomListEnumSerializer extends JsonSerializer<List<BaseEnum>> {
    /**
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(List<BaseEnum> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ArrayList<String> values = Lists.newArrayList();
        for (BaseEnum baseEnum : value) {
            values.add(baseEnum.getName());
        }
        gen.writeObject(values);
    }
}
