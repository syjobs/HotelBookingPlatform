package com.yang.hrms.dto;

import java.io.Serializable;

/**
 * @author sunyang
 * @date 2018/3/23
 */
public class DeleteHintDto implements Serializable{
    private boolean flag;
    private String message;

    public DeleteHintDto() {
    }

    public DeleteHintDto(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
