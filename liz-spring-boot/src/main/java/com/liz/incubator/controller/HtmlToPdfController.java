package com.liz.incubator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/1/10.
 */
@RestController
public class HtmlToPdfController {

    private static final Logger log = LogManager.getLogger(HelloController.class);

    @RequestMapping("/htmlToPdf")
    public String htmlToPdf(){
        log.info("htmlToPdf");
        return "htmlToPdf";

    }
}
