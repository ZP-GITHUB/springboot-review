package com.zp.springbootjackson.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zp.springbootjackson.pojo.User;

import java.io.IOException;

/**
 * @author ZP
 * @date 2021/4/12.
 * TODO 自定义序列化类
 */
public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User user, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeStringField("user-name", user.getUserName());
        generator.writeEndObject();
    }
}