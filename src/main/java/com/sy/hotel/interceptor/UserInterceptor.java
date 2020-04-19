package com.sy.hotel.interceptor;

import com.sy.hotel.domain.User;
import com.sy.hotel.constant.HintConstant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/3/22
 * 拦截路径：
 * user/doLogout
 * user/toInformation
 * user/reservation/showByUser
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
            return true;
        } else {
            String hint = URLEncoder.encode(HintConstant.OUT_LOGIN, "utf-8");
            httpServletResponse.sendRedirect("/user/toLogin?hint=" + hint);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
