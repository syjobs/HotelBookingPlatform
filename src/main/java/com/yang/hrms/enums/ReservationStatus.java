package com.yang.hrms.enums;

import java.io.Serializable;

/**
 * @author sunyang
 * @date 2019/12/5
 * 酒店房型预订单的处理情况
 */
public enum ReservationStatus implements Serializable{
    REVOKING("已取消"),
    ORDERED("预订成功"),
    PROCESSED("已办理入住"),
    CLEARED("已退房");

    private String status;

    private ReservationStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }
}
