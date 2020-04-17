package com.yang.hrms.service.impl;

import com.yang.hrms.domain.Promotion;
import com.yang.hrms.mapper.PromotionMapper;
import com.yang.hrms.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/4/22
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public boolean add(Promotion promotion) {
        return promotionMapper.save(promotion)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return promotionMapper.delete(id)==1;
    }

    @Override
    public List<Promotion> listAll() {
        return promotionMapper.listAll();
    }
}
