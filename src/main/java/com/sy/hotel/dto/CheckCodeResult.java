package com.sy.hotel.dto;

import java.io.Serializable;

/**
 * @author sunyang
 * @date 2019/12/13
 * 验证短信验证码的结果
 */
public class CheckCodeResult implements Serializable{
    private Boolean success;

    public CheckCodeResult() {
    }

    public CheckCodeResult(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
