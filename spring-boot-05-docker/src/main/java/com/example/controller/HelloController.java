package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-02-07 10:28:19
 */
@RestController
@RequestMapping
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
