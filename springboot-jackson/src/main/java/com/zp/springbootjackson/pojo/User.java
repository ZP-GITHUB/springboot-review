package com.zp.springbootjackson.pojo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zp.springbootjackson.config.UserDeserializer;
import com.zp.springbootjackson.config.UserSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZP
 * @date 2021/4/12.
 */
//@JsonIgnoreProperties({ "password", "age" })  //@JsonIgnoreProperties，忽略一组属性，作用于类上
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class) //@JsonNaming，用于指定一个命名策略，作用于类或者属性上。Jackson自带了多种命名策略，你可以实现自己的命名策略，比如输出的key 由Java命名方式转为下面线命名方法 —— userName转化为user-name
//@JsonSerialize(using = UserSerializer.class)  //指定一个实现类来自定义序列化。类必须实现JsonSerializer接口
//@JsonDeserialize(using = UserDeserializer.class)  //使用注解@JsonDeserialize来指定User对象的序列化方式：访问 /readjsonasobject
public class User implements Serializable {
    private static final long serialVersionUID = 6222176558369919436L;

    // 只返回userName
    public interface UserNameView {
    };

    // 返回所有包括userName
    public interface AllUserFieldView extends UserNameView {
    };

    @JsonView(UserNameView.class)
    private String userName;

    @JsonView(AllUserFieldView.class)
    private int age;


//    @JsonIgnore  //@Jsonlgnore，作用在属性上，用来忽略此属性。
    @JsonView(AllUserFieldView.class)
    private String password;

//    @JsonProperty("bth") //@JsonProperty，作用在属性上，用来为JSON Key指定一个别名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //@JsonFormat，用于日期格式化
    @JsonView(AllUserFieldView.class)
    private Date birthday;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
