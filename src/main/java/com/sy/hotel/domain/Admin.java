package com.sy.hotel.domain;

import java.io.Serializable;

/**
 * @author sunyang
 * @date 2019/12/1
 * 管理员
 */
public class Admin implements Serializable{
    //主键id
    private Integer id;
    //管理员登录名
    private String username;
    //口令
    private String password;
    //真实姓名
    private String realName;
    //员工编号
    private String empNum;
    //是否是超级管理员 true-超级管理员,false-普通管理员
    private Boolean superAdmin=false;

    public Admin() {
    }

    public Admin(String username, String password, String realName, String empNum) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.empNum = empNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }
}
