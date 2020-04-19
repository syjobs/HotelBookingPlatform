package com.sy.hotel.service;

import com.sy.hotel.domain.RoomPhoto;

/**
 * @author sunyang
 * @date 2018/4/22
 */
public interface PhotoService {

    boolean add(RoomPhoto photo);

    boolean delete(Integer id);
}
