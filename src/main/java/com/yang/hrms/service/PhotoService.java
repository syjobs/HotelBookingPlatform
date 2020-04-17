package com.yang.hrms.service;

import com.yang.hrms.domain.RoomPhoto;

/**
 * @author sunyang
 * @date 2018/4/22
 */
public interface PhotoService {

    boolean add(RoomPhoto photo);

    boolean delete(Integer id);
}
