package com.liz.incubator.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseController{

    private static Log log = LogFactory.getLog(HelloController.class);

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
