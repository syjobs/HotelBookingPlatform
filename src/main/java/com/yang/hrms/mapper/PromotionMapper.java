package com.yang.hrms.mapper;

import com.yang.hrms.domain.Promotion;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/6
 */
public interface PromotionMapper {

    int save(Promotion promotion);

    int delete(Integer id);

    int update(Promotion promotion);

    Promotion findById(Integer id);

    List<Promotion> listAll();
}
