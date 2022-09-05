package com.wen.backresult.controller;

import com.wen.backresult.pojo.Person;
import com.wen.backresult.vo.ResultVO;
import com.wen.backresult.util.ResultUtil;
import com.wen.releasedao.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {
    @Resource
    BaseMapper mapper;

    @GetMapping("/get")
    public ResultVO getPerson(@RequestParam("id") String id) {
        mapper.get(Person.class);
        Person person = new Person(Integer.parseInt(id), "wen", 200);
        return ResultUtil.success(person);
    }

    @GetMapping("/get/all")
    public ResultVO getPersonAll() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(2, "wen", 200));
        list.add(new Person(2, "hai", 200));
        list.add(new Person(2, "long", 200));
        return ResultUtil.success(list);
    }

    @GetMapping("/error")
    public ResultVO error() {
        log.info("info");
        log.warn("warn");
        log.error("error");
        System.out.println(2 / 0);
        return ResultUtil.error("一个错误");
    }

}
