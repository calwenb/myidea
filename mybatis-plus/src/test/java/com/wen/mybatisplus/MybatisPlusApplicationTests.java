package com.wen.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wen.mybatisplus.mapper.UserMapper;
import com.wen.mybatisplus.pojo.User;
import com.wen.releasedao.core.mapper.BaseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Resource
    BaseMapper baseMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void t1() {
        User user = baseMapper.selectTarget(User.class);
        System.out.println(user);
//        for (int i = 0; i < 50; i++) {
//            User user = new User(100 + i, "wen", "123", 15 + i);
//            userMapper.insert(user);
//        }
    }

    @Test
    void t0() {
        User user = new User();
        user.setUsername("wen").setPassword("123").setAge(12);
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    void t2() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }

    @Test
    void t3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    @Test
    void t4() {
        Page<User> userPage = userMapper.selectPage(new Page<>(2, 5), null);
        List<User> users = userPage.getRecords();
        users.forEach(System.out::println);
    }

    @Test
    void t5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "hai").eq("score", 52);
        userMapper.delete(wrapper);
    }

    @Test
    void t6() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("username", "admin");
        User user = new User();
        user.setPassword("456123");
        userMapper.update(user, wrapper);
    }

    @Test
    void t7() {
        User user = new User();
        user.setId(20);
        user.setPassword("666");
        userMapper.updateById(user);
    }

    @Test
    void t8() {
        //current 当前页
        // size 一页大小，mp会自动计算分页
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    void t9() {
        //根据主键删除
        userMapper.deleteById(12);
    }

    @Test
    void t10() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "admin").or().eq("age", 37)
                .select("username");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


}
