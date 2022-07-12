package com.wen.mybatisplus;

import com.wen.mybatisplus.mapper.UserMapper;
import com.wen.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SpringBootTest
public class WenTest {
    @Resource
    UserMapper userMapper;

    @Test
    void addGigData() {

        int capacity = (int) Math.pow(2, 20);
        ArrayList<User> list = new ArrayList<>(capacity);
        int i1 = capacity;
        for (int i = 0; i < i1; i++) {
            list.add(new User(i, "wen " + i, i + "", i));

        }
        System.out.println("start=================");
        System.out.println(capacity);
        long l = System.currentTimeMillis();
        int num = 32;
        int offset;
        int pageSize = capacity / num;
        for (offset = 1; offset <= num; offset++) {
            List<User> page = list.stream().skip((offset - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            userMapper.insertBatchSomeColumn(page);
        }


        long time = System.currentTimeMillis() - l;
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(time) + " s");
    }

    @Test
    void addGigData2() {

        int capacity = (int) Math.pow(2, 17);
        ArrayList<User> list = new ArrayList<>(capacity);
        int i1 = capacity;
        for (int i = 0; i < i1; i++) {
            list.add(new User(i, "wen " + i, i + "", i));

        }
        System.out.println("start=================");
        System.out.println(capacity);

        long l = System.currentTimeMillis();
        userMapper.insertBatchSomeColumn(list);


        long time = System.currentTimeMillis() - l;

        System.out.println(TimeUnit.MILLISECONDS.toSeconds(time) + " s");
        System.out.println("start=================");
        System.out.println(capacity);
    }
}
