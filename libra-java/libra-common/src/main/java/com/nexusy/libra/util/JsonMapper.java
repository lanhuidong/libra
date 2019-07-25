package com.nexusy.libra.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.netty.util.internal.EmptyArrays;

import java.io.IOException;
import java.util.TimeZone;

/**
 * @author lan
 * @since 2019-01-31
 */
public final class JsonMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.setTimeZone(TimeZone.getDefault());
    }

    private JsonMapper() {
    }

    public static byte[] writeValue(Object object) {
        try {
            return MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
        }
        return EmptyArrays.EMPTY_BYTES;
    }

    public static <T> T readValue(String json, Class<T> clazz) {
        T object = null;
        if (json != null && json.length() != 0) {
            try {
                object = MAPPER.readValue(json, clazz);
            } catch (IOException e) {
            }
        }
        return object;
    }

    public static <T> T readValue(byte[] json, Class<T> clazz) {
        T object = null;
        if (json != null && json.length != 0) {
            try {
                object = MAPPER.readValue(json, clazz);
            } catch (IOException e) {
            }
        }
        return object;
    }

    public static <T> T convert(Object o, Class<T> clazz) {
        return MAPPER.convertValue(o, clazz);
    }

}
