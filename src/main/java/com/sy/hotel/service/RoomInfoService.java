package com.sy.hotel.service;

import com.sy.hotel.domain.RoomCatalog;
import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.domain.RoomPhoto;
import com.sy.hotel.dto.CheckRoomNumDto;
import com.sy.hotel.dto.PageQueryResult;

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
