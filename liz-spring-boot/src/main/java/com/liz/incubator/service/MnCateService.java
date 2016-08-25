/*
 * Powered By [Frank-Liz-Lee]
 * Copyright(C) 2012-2016 Liz Company
 * All rights reserved.
 * -----------------------------------------------
 */

package com.liz.incubator.service;

import com.liz.common.pojo.Pagination;
import com.liz.incubator.mapper.MnCateMapper;
import com.liz.incubator.model.MnCate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public class MnCateService {

    private MnCateMapper mnCateMapper;

    @Autowired
    public void setMnCateMapper(MnCateMapper mnCateMapper) {
        this.mnCateMapper = mnCateMapper;
    }

    /**
     * 通过主键查询实体对象
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public MnCate getByPK(java.lang.Integer primaryKey) throws Exception {
        return mnCateMapper.getByPK(primaryKey);
    }

    /**
     * 查询所有记录
     * @return
     * @throws Exception
     */
    public List<MnCate> list() throws Exception {
        return mnCateMapper.list();
    }

    /**
     * 根据查询条件查询所有记录
     * @return
     * @throws Exception
     */
    public List<MnCate> listByProperty(MnCate mnCate)throws Exception {
        return mnCateMapper.listByProperty(mnCate);
    }


    /**
     * 根据主键删除记录
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public int deleteByPK(java.lang.Integer primaryKey) throws Exception {
        return mnCateMapper.deleteByPK(primaryKey);
    }

    /**
     * 根据多个主键删除记录
     * @param primaryKeys
     * @throws Exception
     */
    public void deleteByPKeys(List<java.lang.Integer> primaryKeys) throws Exception {
        mnCateMapper.deleteByPKeys(primaryKeys);
    }

    /**
     * 根据传入参数删除记录
     * @param mnCate
     * @return
     * @throws Exception
     */
    public int deleteByProperty(MnCate mnCate) throws Exception {
        return mnCateMapper.deleteByProperty(mnCate);
    }

    /**
     * 保存记录
     * @param mnCate
     * @return
     * @throws Exception
     */
    public void save(MnCate mnCate) throws Exception {
        mnCateMapper.save(mnCate);
    }

    /**
     * 更新记录
     * @param mnCate
     * @return
     * @throws Exception
     */
    public int update(MnCate mnCate) throws Exception{
        return mnCateMapper.update(mnCate);
    }

    /**
     * 根据条件查询记录条数
     * @param mnCate
     * @return
     * @throws Exception
     */
    public int findByCount(MnCate mnCate) throws Exception {
        return mnCateMapper.findByCount(mnCate);
    }

    /**
     * 根据查询条件查询分页记录
     * @return
     * @throws Exception
     */
    public Pagination<MnCate> findByPagination(Pagination<MnCate> pagination, MnCate mnCate) throws Exception{
        List<MnCate> list = mnCateMapper.findByPagination(pagination, mnCate);
        pagination.setResultList(list);
        return pagination;
    }

}
