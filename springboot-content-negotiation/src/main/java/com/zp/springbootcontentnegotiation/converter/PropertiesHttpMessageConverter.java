package com.zp.springbootcontentnegotiation.converter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @author ZP
 * @date 2021/4/26.
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {
    /**我们在PropertiesHttpMessageConverter的构造器中添加相应的媒体类型*/
    public PropertiesHttpMessageConverter() {
        super(new MediaType("text", "properties"));
    }
    /**writeInternal为序列化过程，将响应序列化。*/
    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 获取请求头
        HttpHeaders headers = outputMessage.getHeaders();
        // 获取 content-type
        MediaType contentType = headers.getContentType();
        // 获取编码
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }

        charset = charset == null ? Charset.forName("UTF-8") : charset;

        // 获取请求体
        OutputStream body = outputMessage.getBody();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(body, charset);

        properties.store(outputStreamWriter, "Serialized by PropertiesHttpMessageConverter#writeInternal");
    }

    /**readxxx为反序列化过程，即将HTTP请求反序列化为参数的过程；*/
    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Properties properties = new Properties();
        // 获取请求头
        HttpHeaders headers = inputMessage.getHeaders();
        // 获取 content-type
        MediaType contentType = headers.getContentType();
        // 获取编码
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }

        charset = charset == null ? Charset.forName("UTF-8") : charset;

        // 获取请求体
        InputStream body = inputMessage.getBody();
        InputStreamReader inputStreamReader = new InputStreamReader(body, charset);

        properties.load(inputStreamReader);
        return properties;
    }
    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}