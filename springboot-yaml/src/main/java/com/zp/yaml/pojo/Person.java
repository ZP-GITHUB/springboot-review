package com.zp.yaml.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 @ConfigurationProperties作用：
 将配置文件中配置的每一个属性的值，映射到这个组件中；
 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应
 * @author ZP
 * @date 2020/8/24.
 */
@Data
@Validated
@Component //注册bean
@ConfigurationProperties(prefix = "person")
public class Person {

    @NotNull(message="名字不能为空")
    private String name;
    @Max(value=120,message="年龄最大不能查过120")
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
