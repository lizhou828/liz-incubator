package com.liz.incubator.controller;

import com.liz.common.component.cache.MemcacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lizhou on 2015/10/14
 */

@Controller
public class JspController extends BaseController{

    @RequestMapping("/welcome")
    public String welcome(ModelMap modelMap){
        return "welcome";
    }
}
