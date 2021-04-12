package com.zp.springbootjackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zp.springbootjackson.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author ZP
 * @date 2021/4/12.
 */
@Controller
public class UserController {

    @RequestMapping("getuser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserName("mrbird");
        user.setBirthday(new Date());
        return user;
    }

    /**
     * 只返回username字段
     * @return
     */
    @JsonView(User.UserNameView.class)
    @RequestMapping("getuser1")
    @ResponseBody
    public User getUser1() {
        User user = new User();
        user.setUserName("mrbird");
        user.setAge(26);
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }

    /**
     * 返回所有字段
     * @return
     */
    @JsonView(User.AllUserFieldView.class)
    @RequestMapping("getuser2")
    @ResponseBody
    public User getUser2() {
        User user = new User();
        user.setUserName("mrbird");
        user.setAge(26);
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }

    @Autowired
    ObjectMapper mapper;

    @RequestMapping("serialization")
    @ResponseBody
    public String serialization() {
        try {
            User user = new User();
            user.setUserName("mrbird");
            user.setBirthday(new Date());
            String str = mapper.writeValueAsString(user);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当采用树遍历的方式时，JSON被读入到JsonNode对象中，可以像操作XML DOM那样读取JSON
     * @return
     */
    @RequestMapping("readjsonstring")
    @ResponseBody
    public String readJsonString() {
        try {
            String json = "{\"name\":\"mrbird\",\"age\":26}";
            JsonNode node = this.mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Java对象和JSON数据进行绑定
     * @return
     */
    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
//            String json = "{\"userName\":\"mrbird\",\"age\":26}";
            String json = "{\"user-name\":\"mrbird\"}";
            User user = mapper.readValue(json, User.class);
            String name = user.getUserName();
            int age = user.getAge();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("customize")
    @ResponseBody
    public String customize() throws JsonParseException, JsonMappingException, IOException {
        String jsonStr = "[{\"userName\":\"mrbird\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (User user : list) {
            msg += user.getUserName();
        }
        return msg;
    }
}
