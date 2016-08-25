/*
 * Powered By [Frank-Liz-Lee]
 * Copyright(C) 2012-2016 Liz Company
 * All rights reserved.
 * -----------------------------------------------
 */
package com.liz.incubator.mapper;

import java.util.List;

import com.liz.incubator.model.MnCate;
import com.liz.incubator.mapper.GenericIBatisMapper;
import com.liz.common.pojo.Pagination;

public interface MnCateMapper extends GenericIBatisMapper <MnCate, Integer>{

    public List<MnCate> findByPagination(Pagination<MnCate> pagination, MnCate mnCate);

}