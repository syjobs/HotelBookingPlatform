package com.yang.hrms.domain;

import java.io.Serializable;

/**
 * @author sunyang
 * @date 2019/12/1
 * 酒店酒店类别
 */
public class RoomCatalog implements Serializable{
    //主键id
    private Integer id;
    //类别名称
    private String catalog;

    public RoomCatalog() {
    }

    public RoomCatalog(String catalog) {
        this.catalog = catalog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
