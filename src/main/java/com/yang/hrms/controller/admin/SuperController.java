package com.yang.hrms.controller.admin;

import com.yang.hrms.constant.HintConstant;
import com.yang.hrms.dto.AddAdminDto;
import com.yang.hrms.dto.CheckUsernameResult;
import com.yang.hrms.dto.DeleteHintDto;
import com.yang.hrms.service.AdminService;
import com.yang.hrms.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyang
 * @date 2018/3/21
 */
@Controller
@RequestMapping("/super")
public class SuperController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoomInfoService roomService;

    @GetMapping("/toSuper")
    public String toSuper(HttpServletRequest request) {
        request.getSession().removeAttribute("catalog");
        request.setAttribute("catalogList", roomService.listAllCatalog());
        return "admin/super";
    }


    @GetMapping("doShowAllAdmin")
    public String doShowAllAdmin(HttpServletRequest request) {
        request.setAttribute("adminList", adminService.listAll());
        return "admin/adminInfo";
    }

    @GetMapping("/toAddAdmin")
    public String toAddAdmin() {
        return "admin/addAdmin";
    }

    @GetMapping("/doCheckUsername")
    @ResponseBody
    public CheckUsernameResult checkUsername(String username) {
        return adminService.checkUsername(username);
    }

    @PostMapping("doAddAdmin")
    public String doAddAdmin(AddAdminDto addAdminDto, HttpServletRequest request) {
        if (adminService.register(addAdminDto)) {
            return "redirect:doShowAllAdmin";
        } else {
            request.setAttribute("hint", HintConstant.ADD_FAILED);
            return "admin/addAdmin";
        }
    }

    @GetMapping("/doDeleteAdmin")//ajax请求
    @ResponseBody
    public DeleteHintDto doDeleteAdmin(Integer id) {
        if (id != null && adminService.delete(id)) {
            return new DeleteHintDto(true, HintConstant.DELETE_SUCCESS);
        }
        return new DeleteHintDto(false, HintConstant.DELETE_FAILED);
    }
}
