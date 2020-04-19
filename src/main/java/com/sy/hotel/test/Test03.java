package com.sy.hotel.test;

import com.sy.hotel.util.MyUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author sunyang
 * @date 2019/12/13
 * 测试一个第三方短信API
 */
public class Test03 {

    public static void doGet(String phone,String code){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        CloseableHttpResponse response=null;
        String url ="http://sms.tehir.cn/code/sms/api/v1/send?srcSeqId=123&account=18308461767&password=liyuxiang951112&mobile="+phone+"&code="+code+"&time=1";
        HttpGet httpGet = new HttpGet(url);
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String jsonStr = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(jsonStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String code= MyUtils.getRandomCode(4);
        System.out.println(code);
        doGet("18980453283",code);
    }

}
