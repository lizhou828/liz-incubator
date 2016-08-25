/*
 * Powered By [Frank-Liz-Lee]
 * Copyright(C) 2012-2016 Liz Company
 * All rights reserved.
 * -----------------------------------------------
 */
package com.liz.incubator.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

public class MnCate implements Serializable {

    private static final long serialVersionUID = 1L;

    /*  */
    private java.lang.Integer cateId;
    /*  */
    private java.lang.String cateName;
    /*  */
    private java.lang.Integer parentId;
    /*  */
    private java.lang.Integer sortOrder;

    /*  */
    public java.lang.Integer getCateId() {
        return cateId;
    }
    /*  */
    public void setCateId(java.lang.Integer cateId) {
        this.cateId = cateId;
    }
    /*  */
    public java.lang.String getCateName() {
        return cateName;
    }
    /*  */
    public void setCateName(java.lang.String cateName) {
        this.cateName = cateName;
    }
    /*  */
    public java.lang.Integer getParentId() {
        return parentId;
    }
    /*  */
    public void setParentId(java.lang.Integer parentId) {
        this.parentId = parentId;
    }
    /*  */
    public java.lang.Integer getSortOrder() {
        return sortOrder;
    }
    /*  */
    public void setSortOrder(java.lang.Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String toString() {
        return "MnCate [" +
                ", cateId" + cateId +
                ", cateName" + cateName +
                ", parentId" + parentId +
                ", sortOrder" + sortOrder +
                "]";
    }
}