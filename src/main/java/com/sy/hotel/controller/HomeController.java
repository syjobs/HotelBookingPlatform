package com.sy.hotel.controller;

import com.sy.hotel.util.MyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @author sunyang
 * @date 2019/12/13
 */
@Controller
public class HomeController {

    @GetMapping(value = "getImageCode", produces = "image/png")
    @ResponseBody
    public BufferedImage getImageCode(HttpSession session) {
        String code = MyUtils.getRandomCode(4);
        System.out.println("图片验证码===" + code);
        session.setAttribute("code", code);
        return MyUtils.getRandomCodeImage(code, 80, 30);
    }
}
