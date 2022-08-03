package com.wen.propertiesyaml.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Configuration
@PropertySource("classpath:wen.properties")
public class Test2Config {
    public static String root;

    public static String name1;
    public static String name2;

    @Value("${wen.root}")
    public void setRoot(String root) {
        Test2Config.root = root;
    }

    @Value("${wen.name1}")
    public void setName1(String name1) {
        Test2Config.name1 = Test2Config.root + name1;
    }

    @Value("${wen.name2}")
    public void setName2(String name2) {
        Test2Config.name2 = Test2Config.root + name2;
    }
}
