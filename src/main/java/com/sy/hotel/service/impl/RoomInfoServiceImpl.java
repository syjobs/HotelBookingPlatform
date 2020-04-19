package com.sy.hotel.service.impl;

import com.sy.hotel.constant.HintConstant;
import com.sy.hotel.domain.RoomCatalog;
import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.domain.RoomPhoto;
import com.sy.hotel.dto.CheckRoomNumDto;
import com.sy.hotel.dto.PageQueryResult;
import com.sy.hotel.enums.RoomStatus;
import com.sy.hotel.mapper.RoomCatalogMapper;
import com.sy.hotel.mapper.RoomInfoMapper;
import com.sy.hotel.mapper.RoomPhotoMapper;
import com.sy.hotel.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/3/29
 */
@Service
public class RoomInfoServiceImpl implements RoomInfoService {

    @Autowired
    private RoomInfoMapper roomMapper;

    @Autowired
    private RoomPhotoMapper photoMapper;

    @Autowired
    private RoomCatalogMapper catalogMapper;

    @Override
    public List<RoomInfo> getSomeForIndex() {
        return roomMapper.getByVersion();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addRoomCatalog(RoomCatalog catalog) {
        RoomCatalog temp = catalogMapper.selectByCatalogName(catalog.getCatalog());
        if (temp != null) {
            return false;
        }
        return catalogMapper.save(catalog) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteRoomCatalog(Integer catalogId) {
        boolean flag = false;
        int count = roomMapper.countByRoomCatalogId(catalogId);
        if (count == 0) {
            catalogMapper.delete(catalogId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<RoomCatalog> listAllCatalog() {
        return catalogMapper.listAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addRoomInfo(RoomInfo roomInfo) {
        roomInfo.setRoomStatus(RoomStatus.LEISURE);
        return roomMapper.save(roomInfo) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addPhoto(RoomPhoto photo) {
        return photoMapper.save(photo) == 1;
    }

    @Override
    public CheckRoomNumDto checkRoomNum(String roomNum) {
        CheckRoomNumDto checkNum = new CheckRoomNumDto();
        checkNum.setRoomNum(roomNum);
        RoomInfo room = roomMapper.selectByNum(roomNum);
        if (room != null) {
            checkNum.setMessage(HintConstant.ROOMNUM_REPEATED);
            checkNum.setValid(true);
            return checkNum;
        }
        checkNum.setMessage(HintConstant.ROOMNUM_VALID);
        checkNum.setValid(false);
        return checkNum;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteRoomInfoAndPhoto(String roomNum) {
        boolean flag = false;
        RoomInfo room = roomMapper.selectByNum(roomNum);
        if (room != null && room.getRoomStatus().getStatus().equals(RoomStatus.LEISURE.getStatus())) {
            photoMapper.deleteByRoomId(room.getId());
            roomMapper.deleteByRoomNum(roomNum);
            flag = true;
        }
        return flag;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletePhoto(Integer photoId) {
        photoMapper.delete(photoId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateRoomInfo(RoomInfo roomInfo) {
        return roomMapper.update(roomInfo) == 1;
    }

    @Override
    public RoomCatalog findCatalogById(Integer catalogId) {
        return catalogMapper.selectById(catalogId);
    }

    @Override
    public RoomInfo findRoomByRoomNum(String roomNum) {
        return roomMapper.selectByNum(roomNum);
    }

    @Override
    public List<RoomPhoto> listPhotosByRoomId(Integer roomId) {
        return photoMapper.listByRoomInfoId(roomId);
    }

    @Override
    public PageQueryResult<RoomInfo> pageRoomsByCatalog(Integer catalogId, Integer currentPage, Integer pageSize) {
        Integer totalRecords = roomMapper.countByRoomCatalogId(catalogId);
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 10 : pageSize;
        List<RoomInfo> roomInfoList = roomMapper.pageByRoomCatalogId(catalogId, (currentPage - 1) * pageSize, pageSize);
        int totalPages = (totalRecords - 1) / pageSize + 1;
        return new PageQueryResult<>(currentPage, pageSize, totalRecords, totalPages, roomInfoList);
    }

    @Override
    public PageQueryResult<RoomInfo> pageAllRoom(Integer currentPage, Integer pageSize) {
        Integer totalRecords = roomMapper.count();
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 10 : pageSize;
        List<RoomInfo> roomInfoList = roomMapper.page( (currentPage - 1) * pageSize, pageSize);
        int totalPages = (totalRecords - 1) / pageSize + 1;
        return new PageQueryResult<>(currentPage, pageSize, totalRecords, totalPages, roomInfoList);
    }
}
