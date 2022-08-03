package com.wen.propertiesyaml;

import com.wen.propertiesyaml.config.Test2Config;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PropertiesYamlApplicationTests {

    @Test
    void contextLoads() {
    }

/*
    @Test
    void t1() {
        System.out.println(TestConfig.name);
    }*/


    @Test
    void t2() {
        System.out.println(Test2Config.root);
        System.out.println(Test2Config.name1);

        System.out.println(Test2Config.name2);
    }

}
