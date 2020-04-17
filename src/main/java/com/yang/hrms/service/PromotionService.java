package com.yang.hrms.service;

import com.yang.hrms.domain.Promotion;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/4/22
 * 酒店活动业务层
 */
public interface PromotionService {

    boolean add(Promotion promotion);

    boolean delete(Integer id);

    List<Promotion> listAll();
}
