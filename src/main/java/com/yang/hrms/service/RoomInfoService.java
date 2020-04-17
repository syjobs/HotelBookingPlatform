package com.yang.hrms.service;

import com.yang.hrms.domain.RoomCatalog;
import com.yang.hrms.domain.RoomInfo;
import com.yang.hrms.domain.RoomPhoto;
import com.yang.hrms.dto.CheckRoomNumDto;
import com.yang.hrms.dto.PageQueryResult;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/3/28
 */
public interface RoomInfoService {
    List<RoomInfo> getSomeForIndex();

    boolean addRoomCatalog(RoomCatalog catalog);

    boolean deleteRoomCatalog(Integer catalogId);

    List<RoomCatalog> listAllCatalog();

    boolean addRoomInfo(RoomInfo roomInfo);

    boolean addPhoto(RoomPhoto photo);

    CheckRoomNumDto checkRoomNum(String roomNum);

    boolean deleteRoomInfoAndPhoto(String roomNum);

    void deletePhoto(Integer photoId);

    boolean updateRoomInfo(RoomInfo roomInfo);

    RoomCatalog findCatalogById(Integer catalogId);

    RoomInfo findRoomByRoomNum(String roomNum);

    List<RoomPhoto> listPhotosByRoomId(Integer roomId);

    PageQueryResult<RoomInfo> pageRoomsByCatalog(Integer catalogId, Integer currentPage, Integer pageSize);

    PageQueryResult<RoomInfo> pageAllRoom(Integer currentPage,Integer pageSize);
}
