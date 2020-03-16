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
    public ModelAndView welcome(ModelMap modelMap){
        return new ModelAndView("welcome");
    }

    /**
     * 在网页中预览doc文件
     * 使用微软云端的接口，在线预览doc文件
     * 注意：链接包含中文需要进行URL编码，并且文档必须可在Internet上公开访问(公网访问地址)
     * 官方地址：
     * https://www.microsoft.com/en-us/microsoft-365/blog/2013/04/10/office-web-viewer-view-office-documents-in-a-browser/
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/doc",method = RequestMethod.GET)
    public ModelAndView doc(ModelMap modelMap){
        return new ModelAndView("doc");
    }

    /**
     * 在网页中预览docx文件
     * 使用微软云端的接口，在线预览docx文件
     * 注意：链接包含中文需要进行URL编码，并且文档必须可在Internet上公开访问(公网访问地址)
     * 官方地址：
     * https://www.microsoft.com/en-us/microsoft-365/blog/2013/04/10/office-web-viewer-view-office-documents-in-a-browser/
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/docx",method = RequestMethod.GET)
    public ModelAndView docx(ModelMap modelMap){
        return new ModelAndView("docx");
    }

    /**
     * 在网页中预览pdf文件
     * 采用PDF.js的解决方案
     * 前提条件：支持HTML5的浏览器
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/pdf",method = RequestMethod.GET)
    public ModelAndView pdf(ModelMap modelMap){
        return new ModelAndView("pdf");
    }


}
