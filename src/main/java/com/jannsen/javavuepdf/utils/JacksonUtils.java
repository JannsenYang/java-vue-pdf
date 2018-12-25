package com.jannsen.javavuepdf.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @author jannsenyang@outlook.com on 2016/11/22.
 */
public class JacksonUtils {

    public static <T> T readValue(String content, Class<T> valueType) throws RuntimeException {
        try {
            return new JacksonObjectMapper().readValue(content, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(String content, TypeReference valueTypeRef) throws RuntimeException {
        try {
            return new JacksonObjectMapper().readValue(content, valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String writeValueAsString(Object value) throws RuntimeException {
        try {
            return new JacksonObjectMapper().writeValueAsString(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class JacksonObjectMapper extends ObjectMapper {

    public JacksonObjectMapper() {
        super();

        // 序列化时忽略null的域
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        this.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        // 忽略Json中存在，但对象中不存在的域
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        this.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        this.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        // 日期相关，禁止夏时
        this.setTimeZone(TimeZone.getTimeZone(ZoneId.of("GMT+8")));
        // 自定义序列化
        this.registerModule(new SimpleModule().addSerializer(java.sql.Date.class, new DateSerializer()));
        // 自定义序列化，把ObjectId转化为String
        this.registerModule(new SimpleModule().addSerializer(ObjectId.class, new JsonSerializer<ObjectId>() {
            @Override
            public void serialize(ObjectId value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
                jsonGenerator.writeObject(value.toString());
            }
        }));

        this.registerModule((new SimpleModule()).addDeserializer(String.class, new JsonDeserializer<String>() {
            @Override
            public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                JsonNode node = jsonParser.readValueAsTree();
                if (node.asText().isEmpty()) {
                    return null;
                }
                if (StringUtils.isEmpty(node.asText().trim())) {
                    return null;
                }
                return node.asText().trim();
            }
        }));
    }
}
