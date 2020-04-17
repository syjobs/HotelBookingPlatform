package com.yang.hrms.service.impl;

import com.yang.hrms.domain.RoomPhoto;
import com.yang.hrms.mapper.RoomPhotoMapper;
import com.yang.hrms.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyang
 * @date 2018/4/22
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private RoomPhotoMapper photoMapper;

    @Override
    public boolean add(RoomPhoto photo) {
        return photoMapper.save(photo)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return photoMapper.delete(id)==1;
    }
}
