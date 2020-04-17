package com.yang.hrms.manager;

import com.yang.hrms.dto.SMSResponse;

/**
 * @author sunyang
 * @date 2019/12/13
 * 业务下沉
 * 通过HttpClient调用第三方服务
 */
public interface HttpClientManager {

    /**
     * 发送短信验证码
     * @param name
     * @param phone
     * @param code
     * @return
     */
    SMSResponse sendSMS(String name, String phone, String code);

}
