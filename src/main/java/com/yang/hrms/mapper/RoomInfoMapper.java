package com.yang.hrms.mapper;

import com.yang.hrms.domain.RoomInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/3
 * 床型类别数据持久层接口
 */
public interface RoomInfoMapper {

    /**
     * 保存某间床型类别
     * @param roomInfo
     * @return
     */
    int save(RoomInfo roomInfo);

    /**
     * 删除某间床型类别
     * @param roomNum
     * @return
     */
    int deleteByRoomNum(String roomNum);

    /**
     * 修改某间房型的信息
     * @param roomInfo
     * @return
     */
    int update(RoomInfo roomInfo);

    /**
     * 改变房型状态
     * @param room
     * @return
     */
    int modifyStatus(RoomInfo room);

    /**
     * 根据房间号找到房间信息
     * @param num
     * @return
     */
    RoomInfo selectByNum(String num);

    /**
     * 查询所有房型的总数
     * @return
     */
    int count();

    /**
     * 分页查询
     * @param offset
     * @param pageSize
     * @return
     */
    List<RoomInfo> page(@Param("offset") Integer offset,
                        @Param("pageSize") Integer pageSize);

    /**
     * 根据酒店id计数房型数量
     * @param id
     * @return
     */
    int countByRoomCatalogId(Integer id);

    /**
     * 根据酒店id分页查询房型
     * @param roomCatalogId
     * @param offset
     * @param pageSize
     * @return
     */
    List<RoomInfo> pageByRoomCatalogId(@Param("roomCatalogId") Integer roomCatalogId,
                                       @Param("offset") Integer offset,
                                       @Param("pageSize") Integer pageSize);

    List<RoomInfo> getByVersion();
}
