package com.thw.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class HelloAction {

    @Autowired
    private DataSource dataSource;

    @GetMapping(value = "hello")
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return "hello world";
    }
}
