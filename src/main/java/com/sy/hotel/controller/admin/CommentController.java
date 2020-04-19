package com.sy.hotel.controller.admin;

import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.service.CommentService;
import com.sy.hotel.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/4/13
 */
@Controller
@RequestMapping("/super/room/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RoomInfoService roomService;

    @GetMapping("/doShowCommentByRoom")
    public String doShowCommentByRoom(String roomNum, Integer currentPage, Integer pageSize, Model model) {
        String viewName = "redirect:doShowRoomByCatalog";
        RoomInfo room = roomService.findRoomByRoomNum(roomNum);
        if (room != null) {
            model.addAttribute("room",room);
            model.addAttribute("commentPage", commentService.pageComment(room, currentPage, pageSize));
            viewName="admin/comment";
        }
        return viewName;
    }

    @GetMapping("/deleteComment")
    @ResponseBody
    public Boolean deleteComment(Integer id){
        return commentService.delete(id);
    }
}
