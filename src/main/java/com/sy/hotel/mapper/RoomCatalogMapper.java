package com.sy.hotel.mapper;

import com.sy.hotel.domain.RoomCatalog;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/3
 * 房型类别-数据持久化接口
 */
public interface RoomCatalogMapper {

    /**
     * 增加酒店
     *
     * @param roomCatalog
     * @return
     */
    int save(RoomCatalog roomCatalog);

    /**
     * 删除某类型
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据类型名称查询酒店
     *
     * @param catalog
     * @return
     */
    RoomCatalog selectByCatalogName(String catalog);

    /**
     * 根据id查询酒店
     *
     * @param id
     * @return
     */
    RoomCatalog selectById(Integer id);

    /**
     * 查找所有酒店
     *
     * @return
     */
    List<RoomCatalog> listAll();
}
