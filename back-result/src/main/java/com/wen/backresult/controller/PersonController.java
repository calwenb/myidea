package com.wen.backresult.controller;

import com.wen.backresult.pojo.Person;
import com.wen.backresult.vo.Result;
import com.wen.backresult.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @GetMapping("/get")
    public Result getPerson(@RequestParam("id") String id) {
        Person person = new Person(Integer.parseInt(id), "wen", 200);
        return ResultUtil.success(person);
    }

    @GetMapping("/get/all")
    public Result getPersonAll() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(2, "wen", 200));
        list.add(new Person(2, "hai", 200));
        list.add(new Person(2, "long", 200));
        return ResultUtil.success(list);
    }

    @GetMapping("/error")
    public Result error() {
        log.info("info");
        log.warn("warn");
        log.error("error");
        System.out.println(2/0);
        return ResultUtil.error("一个错误");
    }

}
