package com.sy.hotel.controller.user;

import com.sy.hotel.domain.RoomCatalog;
import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.service.PromotionService;
import com.sy.hotel.service.RoomInfoService;
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
    @Autowired
    private RoomInfoService roomService;

    @GetMapping(value = {"toIndex", "/"})
    public String toIndex(Model model) {
        model.addAttribute("promotionList", promotionService.listAll());
        List<RoomInfo> roomInfoList = roomInfoService.getSomeForIndex();
        if (null!=roomInfoList && !roomInfoList.isEmpty()) {
            for (int i = 0; i < roomInfoList.size(); i++) {
                RoomInfo roomInfo = roomInfoList.get(i);
                RoomCatalog catalog = roomService.findCatalogById(roomInfo.getRoomCatalog().getId());
                roomInfo.getRoomCatalog().setCatalog(catalog.getCatalog());
                model.addAttribute("room" + i, roomInfo);
            }
        }
        return "user/index";
    }
}
