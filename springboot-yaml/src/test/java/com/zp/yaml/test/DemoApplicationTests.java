package com.zp.yaml.test;

import com.zp.yaml.YamlApplicationRun;
import com.zp.yaml.pojo.Dog;
import com.zp.yaml.pojo.Person;
import com.zp.yaml.pojo.Person2;
import com.zp.yaml.pojo.Person3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZP
 * @date 2020/8/24.
 */
@SpringBootTest(classes = YamlApplicationRun.class)
public class DemoApplicationTests {

    @Autowired  //自动注入
    private Dog dog;

    @Test
    public void contextDogLoads(){
        System.out.println(dog);
    }


    @Autowired
    Person person; //将person自动注入进来

    @Autowired
    Person2 person2; //将person自动注入进来

    @Autowired
    Person3 person3; //将person自动注入进来

    @Test
    public void contextPersonLoads() {
        System.out.println(person); //打印person信息
        System.out.println(person2);
        System.out.println(person3);
    }
}
