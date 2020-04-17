package com.yang.hrms.controller.user;

import com.yang.hrms.domain.RoomInfo;
import com.yang.hrms.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunyang
 * @date 2018/5/3
 */
@Controller
@RequestMapping("/user/room")
public class RoomUController {

    @Autowired
    private RoomInfoService roomService;

    @GetMapping("/showRoomByCatalog")
    public String showRoomByCatalog(Integer catalogId, Integer currentPage,Integer pageSize,Model model){
        model.addAttribute("catalogList",roomService.listAllCatalog());
        if(catalogId==null){
            model.addAttribute("roomPage",roomService.pageAllRoom(currentPage,pageSize));
        }else{
            model.addAttribute("catalog",roomService.findCatalogById(catalogId));
            model.addAttribute("roomPage",roomService.pageRoomsByCatalog(catalogId,currentPage,pageSize));
        }
        return "user/roomInfo";
    }


    @GetMapping("/detailed")
    public String detailed(String roomNum,Model model){
        String viewName="showRoomByCatalog";
        if (roomNum!=null){
            RoomInfo room=roomService.findRoomByRoomNum(roomNum);
            if (room!=null){
                model.addAttribute("roomPhotoList",roomService.listPhotosByRoomId(room.getId()));
                model.addAttribute("room",room);
                viewName="user/detailedRoom";
            }
        }
        return viewName;
    }
}
