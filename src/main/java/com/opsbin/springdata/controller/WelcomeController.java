package com.opsbin.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String welcome() {
        String test = environment.getProperty("testhang");
        return "welcome, " + test + " :)";
    }
}
