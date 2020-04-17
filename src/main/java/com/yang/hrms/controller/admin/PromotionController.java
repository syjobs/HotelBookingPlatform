package com.yang.hrms.controller.admin;

import com.yang.hrms.constant.HintConstant;
import com.yang.hrms.domain.Promotion;
import com.yang.hrms.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author sunyang
 * @date 2018/4/22
 */
@Controller
@RequestMapping("/super/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("doShowPromotion")
    public String doShowPromotion(Model model){
        model.addAttribute("promotionList",promotionService.listAll());
        return "admin/promotion";
    }

    @GetMapping("toAddPromotion")
    public String toAddPromotion(){
        return "admin/addPromotion";
    }

    @PostMapping("/doAddPromotion")
    public String doAddPromotion(Promotion promotion, Model model){
        String viewName="redirect:doShowPromotion";
        if (promotion!=null){
            promotion.setPubDate(new Date());
            if (!promotionService.add(promotion)){
                viewName="admin/addPromotion";
                model.addAttribute("hint", HintConstant.ADD_FAILED);
            }
        }
        return viewName;
    }

    @GetMapping("/deletePromotion")
    @ResponseBody
    public Boolean deletePromotion(Integer promotionId){
        return promotionService.delete(promotionId);
    }
}
