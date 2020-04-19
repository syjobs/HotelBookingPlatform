package com.sy.hotel.service;

import com.sy.hotel.domain.Admin;
import com.sy.hotel.dto.AddAdminDto;
import com.sy.hotel.dto.CheckUsernameResult;
import com.sy.hotel.dto.LoginDto;

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
