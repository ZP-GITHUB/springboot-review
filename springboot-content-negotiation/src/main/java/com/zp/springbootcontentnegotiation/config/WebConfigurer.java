package com.zp.springbootcontentnegotiation.config;

import com.zp.springbootcontentnegotiation.converter.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author ZP
 * @date 2021/4/26.
 * extendMessageConverters方法为WebMvcConfigurer的默认方法，这里我们重写这个方法，
 * 用于将PropertiesHttpMessageConverter添加到消息转换器集合中。
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // converters.add(new PropertiesHttpMessageConverter());
        // 指定顺序，这里为第一个
        converters.add(0, new PropertiesHttpMessageConverter());
    }
}