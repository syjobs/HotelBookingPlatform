package com.yang.hrms.controller.user;

import com.yang.hrms.constant.HintConstant;
import com.yang.hrms.domain.User;
import com.yang.hrms.dto.*;
import com.yang.hrms.manager.HttpClientManager;
import com.yang.hrms.service.UserService;
import com.yang.hrms.util.MyUtils;
import com.yang.hrms.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author sunyang
 * @date 2019/12/13
 */
@Controller
@RequestMapping("/user")
public class UserUController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpClientManager httpClientManager;

    @GetMapping("toRegister")
    public String toRegister() {
        return "user/register";
    }

    @PostMapping("doRegister")
    public String doRegister(@Valid UserRegisterDto userRegisterDto, Errors errors, MultipartFile photo, HttpServletRequest request) throws IOException {
        String viewName = "user/register";
        if (request.getSession().getAttribute("code").toString().equals(userRegisterDto.getCode())) {
            request.getSession().removeAttribute("code");
            if (!errors.hasErrors()) {
                String newName = null;
                String path = request.getServletContext().getRealPath("/upload/user/");
                if (!photo.isEmpty()) {
                    String originalName = photo.getOriginalFilename();
                    newName = MyUtils.getHashFileName(photo.getInputStream()) + MyUtils.getFilenameSuffix(originalName);
                    photo.transferTo(new File(path + newName));
                } else {
                    newName = "default.jpg";
                }
                userRegisterDto.setPhotoPath(newName);
                if (userService.register(userRegisterDto)) {
                    viewName = "redirect:toLogin";
                } else {
                    request.setAttribute("hint", HintConstant.REGISTER_FAILED);
                }
            } else {
                request.setAttribute("hint", HintConstant.REGISTER_FAILED);
            }
        } else {
            request.setAttribute("hint", HintConstant.REGISTER_FAILED);
        }
        return viewName;
    }

    @GetMapping("doSendCode")
    @ResponseBody
    public SMSResponse doSendCode(String realName, String phone, HttpSession session) {
        String code = MyUtils.getRandomCode(4);
        System.out.println("电话验证码="+code);
        session.setAttribute("code", code);
        return httpClientManager.sendSMS(realName, phone, code);
    }

    @GetMapping("doCheckUsername")
    @ResponseBody
    public CheckUsernameResult checkUsername(String username) {
        return userService.checkUsername(username);
    }

    @GetMapping("doCheckCode")
    @ResponseBody
    public CheckCodeResult checkCode(String code, HttpSession session) {
        boolean flag = false;
        String sCode = (String) session.getAttribute("code");
        if (sCode != null && code != null) {
            flag = sCode.equals(code);
        }
        return new CheckCodeResult(flag);
    }

    @GetMapping("toLogin")
    public String toLogin(Model model, String hint) {
        model.addAttribute("hint", hint);
        return "user/login";
    }

    @PostMapping("doLogin")
    public String doLogin(LoginDto loginDto, HttpServletRequest request) {
        String viewName = "user/login";
        String imageCode = request.getSession().getAttribute("code").toString();
        if (imageCode != null && imageCode.equals(loginDto.getCode())) {
            if (userService.login(loginDto)) {
                request.getSession().setAttribute("user", userService.findByUsername(loginDto.getUsername()));
                viewName = "redirect:../toIndex";
            } else {
                request.setAttribute("hint", HintConstant.LOGIN_FAILED);
            }
        } else {
            request.setAttribute("hint", HintConstant.CODE_FAILED);
        }
        return viewName;
    }

    @GetMapping("doLogout")//拦截处理
    public String doLogout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:../toIndex";
    }

    @GetMapping("toInformation")//拦截处理
    public String toShowInformation() {
        return "user/information";
    }

    @GetMapping("/toUpdateInfo")
    public String toUpdate(){
        return "user/updateInfo";
    }

    @PostMapping("/updateInfo")
    public String Update(User user, MultipartFile photo, HttpServletRequest request) throws IOException {
        User old= (User) request.getSession().getAttribute("user");
        if (!photo.isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/user/");
            String originalName = photo.getOriginalFilename();
            String newName = MyUtils.getHashFileName(photo.getInputStream()) + MyUtils.getFilenameSuffix(originalName);
            photo.transferTo(new File(path + newName));
            user.setPhotoPath(newName);
        }
        user.setId(old.getId());
        userService.updateUserInfo(user);
        request.getSession().setAttribute("user",userService.getUserById(old.getId()));
        return "redirect:toInformation";
    }

    @GetMapping("/toUpdatePassWord")
    public String toUpdatePassWord(){
        return "user/updatePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(String password,HttpSession session){
        User user= (User) session.getAttribute("user");
        user.setPassword(password);
        userService.updatePassword(user);
        session.removeAttribute("user");
        return "user/login";
    }
}
