package com.zp.yaml.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 配置文件还可以编写占位符生成随机数
 * @author ZP
 * @date 2020/8/24.
 */
@Data
@Component //注册bean
@ConfigurationProperties(prefix = "personran")
public class Person3 {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
