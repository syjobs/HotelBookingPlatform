package com.sy.hotel.service;

import com.sy.hotel.domain.Promotion;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/4/22
 * 酒店促销信息业务层
 */
public interface PromotionService {

    boolean add(Promotion promotion);

    boolean delete(Integer id);

    List<Promotion> listAll();
}
