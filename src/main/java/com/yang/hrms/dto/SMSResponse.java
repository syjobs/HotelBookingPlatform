package com.yang.hrms.dto;

import java.io.Serializable;

/**
 * @author sunyang
 * @date 2019/12/12
 * 调用第三方短信接口返回的结果对象
 */
public class SMSResponse implements Serializable{

    private Boolean success;

    public SMSResponse() {
    }

    public SMSResponse(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
