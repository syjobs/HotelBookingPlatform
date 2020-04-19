package com.sy.hotel.service.impl;

import com.sy.hotel.domain.Admin;
import com.sy.hotel.dto.AddAdminDto;
import com.sy.hotel.dto.CheckUsernameResult;
import com.sy.hotel.dto.LoginDto;
import com.sy.hotel.mapper.AdminMapper;
import com.sy.hotel.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/8
 * <p>
 * 增加，删除管理员只能超级管理员做
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean register(AddAdminDto addAdminDto) {
        boolean flag = false;
        Admin temp = adminMapper.findByUsername(addAdminDto.getUsername());
        Admin temp1 = adminMapper.findByEmpNum(addAdminDto.getEmpNum());
        if (temp == null && temp1 == null && addAdminDto.getPassword().equals(addAdminDto.getRePassword())) {
            Admin admin = new Admin();
            admin.setUsername(addAdminDto.getUsername());
            admin.setPassword(DigestUtils.md5Hex(addAdminDto.getPassword()));
            admin.setEmpNum(addAdminDto.getEmpNum());
            admin.setRealName(addAdminDto.getRealName());
            admin.setSuperAdmin(false);
            flag = adminMapper.save(admin) == 1;
        }
        return flag;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(Integer id) {
        Admin temp = adminMapper.findById(id);
        if (temp != null && !temp.getSuperAdmin()) {
            return adminMapper.delete(id) == 1;
        }
        return false;
    }

    @Override
    public Admin login(LoginDto loginDto) {
        boolean flag = false;
        Admin admin = adminMapper.findByUsername(loginDto.getUsername());
        if (admin != null) {
            flag = DigestUtils.md5Hex(loginDto.getPassword()).equals(admin.getPassword());
        }
        return flag ? admin : null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePassword(Admin admin) {
        admin.setPassword(DigestUtils.md5Hex(admin.getPassword()));
        return adminMapper.update(admin) == 1;
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.findById(id);
    }

    @Override
    public CheckUsernameResult checkUsername(String username) {
        boolean valid = adminMapper.findByUsername(username) == null;
        String message = valid ? "该用户名可以注册!!!" : "该用户名已被注册,请更换!!!";
        return new CheckUsernameResult(username, valid, message);
    }

    @Override
    public List<Admin> listAll() {
        return adminMapper.listAll();
    }
}
