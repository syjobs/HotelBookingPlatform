package com.sy.hotel.controller.user;

import com.sy.hotel.domain.Reservation;
import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.domain.User;
import com.sy.hotel.enums.ReservationStatus;
import com.sy.hotel.constant.HintConstant;
import com.sy.hotel.service.ReservationService;
import com.sy.hotel.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/3/19
 */
@Controller
@RequestMapping("/user/reservation")
public class ReservationUController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private RoomInfoService roomService;


    @GetMapping("/showByUser")//拦截处理
    public String toShowReservationByUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("reservationList", reservationService.listReservationByUserId(user.getId()));
        return "/user/reservation";
    }

    @GetMapping("/order")
    public String toOrder(String roomNum, Model model) {
        model.addAttribute("roomNum", roomNum);
        return "user/orderInfo";
    }

    @PostMapping("/addByUser")
    public String addByUser(String roomNum, Reservation reservation, HttpServletRequest request) {
        String viewName = "user/orderInfo";
        RoomInfo room = roomService.findRoomByRoomNum(roomNum);
        if (room != null) {
            User user = (User) request.getSession().getAttribute("user");
            reservation.setUser(user);
            reservation.setRoomInfo(room);
            reservation.setOrderTime(new Date());
            if (reservationService.saveReservation(reservation)) {
                viewName = "redirect:showByUser";
            } else {
                request.setAttribute("hint", HintConstant.ORDER_FAILED_STATUS);
            }
        } else {
            request.setAttribute("hint", HintConstant.ORDER_FAILED_NO_ROOM);
        }
        return viewName;
    }

    @GetMapping("/cancel")
    public String cancel(Integer reservationId, Model model) {
        String viewName = "redirect:showByUser";
        if (!reservationService.modifyReservationStatus(ReservationStatus.REVOKING, reservationId, null)) {
            model.addAttribute("hint", HintConstant.CANCEL_FAILED);
        }
        return viewName;
    }
}
