package com.sy.hotel.manager.impl;

import com.alibaba.fastjson.JSON;
import com.sy.hotel.dto.SMSResponse;
import com.sy.hotel.manager.HttpClientManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author sunyang
 * @date 2019/12/13
 */
@Service
public class HttpClientManagerImpl implements HttpClientManager {
    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;

    @Override
    public SMSResponse sendSMS(String name, String phone, String code) {
        SMSResponse smsResponse = null;
        CloseableHttpResponse response=null;
        String urlName = null;
        try {
            urlName = URLEncoder.encode(name, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("字符转百分号编码出错");
        }
        String url = "http://smsapi.api51.cn/name/?code=" + code + "&mobile=" + phone + "&name=" + urlName;
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Authorization", "APPCODE 32fba9b17bbf4a0098a9d0efa8b3f0e7");
        httpGet.setConfig(this.requestConfig);
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String jsonStr = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println("短信API调用结果="+jsonStr);
                smsResponse = JSON.parseObject(jsonStr, SMSResponse.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return smsResponse;
    }
}
