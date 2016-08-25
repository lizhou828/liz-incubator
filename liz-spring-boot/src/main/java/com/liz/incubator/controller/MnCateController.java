/*
 * Powered By [Frank-Liz-Lee]
 * Copyright(C) 2012-2016 Liz Company
 * All rights reserved.
 * -----------------------------------------------
 */

package com.liz.incubator.controller;

import com.liz.incubator.model.MnCate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liz.common.pojo.Pagination;
import com.liz.common.pojo.RequestModel;
import com.liz.incubator.service.MnCateService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
@RequestMapping("/mnCate")
public class MnCateController {

    private static Log log = LogFactory.getLog(MnCateController.class);

    @Autowired
    private MnCateService mnCateService;

    /**
     * 通过主键查询实体对象
     * @return
     */
    @RequestMapping(value = "/getByPK/{key}", method = RequestMethod.GET)
    @ResponseBody
    public MnCate getByPK(@PathVariable("key") Integer key) throws Exception {
        return mnCateService.getByPK(key);
    }

    /**
     * 分页查询记录
     * 请求数据格式：

     {
         "pageNo":1,
         "pageSize":20,
         "paginationFlag":true,
         "param":{
            "parentId":1
         }
     }

     * @return
     */
    @RequestMapping(value = {"/listPg"}, method = RequestMethod.POST)
    @ResponseBody
    public Pagination<MnCate> findByPagination(@RequestBody RequestModel<MnCate> requestModel) throws Exception {
        Pagination<MnCate> pagination = new Pagination<MnCate>();
        pagination.setPaginationFlag(requestModel.isPaginationFlag());
        pagination.setPageNo(requestModel.getPageNo());
        pagination.setPageSize(requestModel.getPageSize());
        return mnCateService.findByPagination(pagination, requestModel.getParam());
    }

    /**
     * 新增记录
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody MnCate mnCate) throws Exception {
        mnCateService.save(mnCate);
    }

    /**
     * 根据多条主键值删除记录
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody List<Integer> list) throws Exception {
        mnCateService.deleteByPKeys(list);
    }

    /**
     * 修改记录
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody MnCate mnCate) throws Exception {
        mnCateService.update(mnCate);
    }

}


