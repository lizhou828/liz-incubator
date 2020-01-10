package com.liz.incubator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseController{

    private static final Logger log = LogManager.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/helloWorld")
    public String helloWord(){
        log.info("Spring boot,Hello World!");
        return "Spring boot,Hello World!";
    }


    
}
