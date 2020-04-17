package com.yang.hrms.mapper;

import com.yang.hrms.domain.RoomCatalog;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/3
 * 客房类别-数据持久化接口
 */
public interface RoomCatalogMapper {

    /**
     * 增加客房类型
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
     * 根据类型名称查询客房类型
     *
     * @param catalog
     * @return
     */
    RoomCatalog selectByCatalogName(String catalog);

    /**
     * 根据id查询客房类型
     *
     * @param id
     * @return
     */
    RoomCatalog selectById(Integer id);

    /**
     * 查找所有客房类型
     *
     * @return
     */
    List<RoomCatalog> listAll();
}
