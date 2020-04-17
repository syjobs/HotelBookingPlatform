package com.yang.hrms.controller.admin;

import com.yang.hrms.constant.HintConstant;
import com.yang.hrms.domain.RoomInfo;
import com.yang.hrms.domain.RoomPhoto;
import com.yang.hrms.service.PhotoService;
import com.yang.hrms.service.RoomInfoService;
import com.yang.hrms.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author sunyang
 * @date 2018/4/22
 */
@Controller
@RequestMapping("/super/room")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private RoomInfoService roomService;

    @GetMapping("/deleteOne")
    public Boolean deleteOne(Integer photoId) {
        return photoService.delete(photoId);
    }

    @GetMapping("/toAddPhoto")
    public String toAddPhoto(String roomNum, Model model) {
        model.addAttribute("roomNum", roomNum);
        return "admin/addPhoto";
    }

    @PostMapping("/addPhoto")
    public String addOne(String roomNum, MultipartFile photo, HttpServletRequest request) throws IOException {
        String viewName = "redirect:doShowRoomByCatalog";
        RoomInfo roomInfo = roomService.findRoomByRoomNum(roomNum);
        if (roomInfo != null) {
            viewName = "redirect:detailedRoomInfo?roomNum="+ URLEncoder.encode(roomNum,"utf-8");
            String path = request.getServletContext().getRealPath("/upload/room/subjoin/");
            String newName = null;
            if (!photo.isEmpty()) {
                newName = MyUtils.getHashFileName(photo.getInputStream()) + MyUtils.getFilenameSuffix(photo.getOriginalFilename());
                photo.transferTo(new File(path + newName));
            } else {
                newName = "default.jpg";
            }
            RoomPhoto roomPhoto = new RoomPhoto();
            roomPhoto.setRoomInfo(roomInfo);
            roomPhoto.setPhotoPath(newName);
            if (!photoService.add(roomPhoto)) {
                request.setAttribute("hint", HintConstant.ADD_FAILED);
                viewName = "admin/addPhoto";
            }
        }
        return viewName;
    }
}
