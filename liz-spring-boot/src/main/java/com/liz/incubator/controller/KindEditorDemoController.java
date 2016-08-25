package com.liz.incubator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lizhou on 2016/3/22
 */

@Controller
@RequestMapping("/kindEditor")
public class KindEditorDemoController {

    @RequestMapping("/demoPage")
    public String demoPage(ModelMap modelMap){
        return "demoPage";
    }

}
