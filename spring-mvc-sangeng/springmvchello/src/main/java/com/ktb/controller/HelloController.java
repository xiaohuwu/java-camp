package com.ktb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping(value = "/{path}")
    public String helloWorld(@PathVariable("path") String path) {
        return path;
    }
}
