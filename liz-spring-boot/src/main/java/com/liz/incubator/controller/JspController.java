package com.liz.incubator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lizhou on 2015/10/14
 * javadoc学习：
 * 1.不能在返回类型为void的方法中使用@return标记
 * 2.在无参的函数前不需要写@param标记，如果写了，则“无参数。”会被认为是参数名。
 */


@Controller
public class JspController extends BaseController{

    /**
     * 1、这是第一行方法说明<br/>
     * 2、这是第二行方法说明<br/>
     * 3、这是第三行方法说明
     * @author lizhou
     * @version Version 1.00
     * @exception NumberFormatException 数字格式化异常
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView welcome(ModelMap modelMap)throws NumberFormatException{
        return new ModelAndView("welcome");
    }
}
