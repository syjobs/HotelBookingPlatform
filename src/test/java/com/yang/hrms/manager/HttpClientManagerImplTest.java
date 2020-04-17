package com.yang.hrms.manager;

import com.yang.hrms.dto.SMSResponse;
import com.yang.hrms.util.MyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunyang
 * @date 2019/12/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class HttpClientManagerImplTest {

    @Autowired
    private HttpClientManager httpClientManager;

    @Test
    public void testSendSMS(){
        String code1= MyUtils.getRandomCode(4);
        System.out.println(code1);
        SMSResponse smsResponse1=httpClientManager.sendSMS("孙阳","18621278619",code1);
        Assert.assertTrue(smsResponse1.getSuccess());

        String code2= MyUtils.getRandomCode(4);
        System.out.println(code2);
        SMSResponse smsResponse2=httpClientManager.sendSMS("黄琪","17621790770",code2);
        Assert.assertTrue(smsResponse2.getSuccess());
    }
}
