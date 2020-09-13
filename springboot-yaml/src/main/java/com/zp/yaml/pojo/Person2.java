package com.zp.yaml.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ZP
 * @date 2020/8/24.
 */
@Data
@PropertySource(value = "classpath:person.properties")
@Component //注册bean
public class Person2 {

    @Value("${name}")
    private String name;
}
