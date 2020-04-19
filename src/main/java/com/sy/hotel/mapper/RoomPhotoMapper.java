package com.sy.hotel.mapper;

import com.sy.hotel.domain.RoomPhoto;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/3
 * 房型图片-数据持久化接口
 */
public interface RoomPhotoMapper {

    /**
     * 保存一张房型图片
     * @param roomPhoto
     * @return
     */
    int save(RoomPhoto roomPhoto);

    /**
     * 删除一张图片
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据房型名称删除所有照片
     * @param roomId
     * @return
     */
    int deleteByRoomId(Integer roomId);

    /**
     * 根据房型id查看其图片展示
     * @param id
     * @return
     */
    List<RoomPhoto> listByRoomInfoId(Integer id);
}
