package com.yang.hrms.service;

import com.yang.hrms.domain.Admin;
import com.yang.hrms.dto.AddAdminDto;
import com.yang.hrms.dto.CheckUsernameResult;
import com.yang.hrms.dto.LoginDto;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/7
 * 管理员的业务接口
 */
public interface AdminService {

    /**
     * 超级管理员指定
     *
     * @return
     */
    boolean register(AddAdminDto addAdminDto);

    /**
     * 超级管理员权限
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    Admin login(LoginDto loginDto);

    boolean updatePassword(Admin admin);

    Admin getById(Integer id);

    CheckUsernameResult checkUsername(String username);

    List<Admin> listAll();
}
