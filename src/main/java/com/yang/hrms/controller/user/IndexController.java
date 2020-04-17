package com.yang.hrms.controller.user;

import com.yang.hrms.domain.RoomInfo;
import com.yang.hrms.service.PromotionService;
import com.yang.hrms.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/5/20
 */
@Controller
public class IndexController {
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private RoomInfoService roomInfoService;

    @GetMapping(value = {"toIndex", "/"})
    public String toIndex(Model model) {
        model.addAttribute("promotionList", promotionService.listAll());
        List<RoomInfo> roomInfoList = roomInfoService.getSomeForIndex();
        if (null!=roomInfoList && !roomInfoList.isEmpty()) {
            for (int i = 0; i < roomInfoList.size(); i++) {
                model.addAttribute("room" + i, roomInfoList.get(i));
            }
        }
        return "user/index";
    }
}
