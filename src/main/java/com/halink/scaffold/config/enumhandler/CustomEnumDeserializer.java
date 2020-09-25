package com.halink.scaffold.config.enumhandler;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.halink.scaffold.common.enumerate.BaseEnum;
import lombok.Setter;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author halink
 */
public class CustomEnumDeserializer extends JsonDeserializer<BaseEnum> implements
        ContextualDeserializer {

    @Setter
    private Class<BaseEnum> enumCls;

    private CustomEnumDeserializer() {
    }

    @Override
    public BaseEnum deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = parser.getCodec();
        JsonNode node = oc.readTree(parser);
        int value = node.asInt();

        String prop = "value";
        return Enums.getEnum(enumCls, prop, value).orElseGet(() ->
                Stream.of(enumCls.getEnumConstants())
                        .filter(e -> e.getValue() == value)
                        .findFirst().orElse(null)
        );
    }

    @Override
    @SuppressWarnings("unchecked")
    public JsonDeserializer createContextual(DeserializationContext ctx, BeanProperty property) {
        Class rawCls = ctx.getContextualType().getRawClass();
        Class<BaseEnum> enumCls = (Class<BaseEnum>) rawCls;
        CustomEnumDeserializer clone = new CustomEnumDeserializer();
        clone.setEnumCls(enumCls);
        return clone;
    }
}

