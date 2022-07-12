package com.wen.propertiesyaml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class PropertiesYamlApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    com.wen.propertiesyaml.test.Test test;

    @Test
    void t1() {
        ReentrantLock lock = new ReentrantLock();
        System.out.println(test.getName());
    }

}
