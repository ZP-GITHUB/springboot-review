package com.zp.springbootmongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ZP
 * @date 2021/5/9.
 */
@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String description;

}