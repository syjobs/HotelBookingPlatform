package com.yang.hrms.service.impl;

import com.yang.hrms.domain.Admin;
import com.yang.hrms.domain.HistoryOrder;
import com.yang.hrms.domain.Reservation;
import com.yang.hrms.domain.RoomInfo;
import com.yang.hrms.dto.PageQueryResult;
import com.yang.hrms.enums.ReservationStatus;
import com.yang.hrms.enums.RoomStatus;
import com.yang.hrms.mapper.AdminMapper;
import com.yang.hrms.mapper.HistoryOrderMapper;
import com.yang.hrms.mapper.ReservationMapper;
import com.yang.hrms.mapper.RoomInfoMapper;
import com.yang.hrms.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/3/19
 */
@Service
public class ReservationServiceTest implements ReservationService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private HistoryOrderMapper historyOrderMapper;

    @Autowired
    private RoomInfoMapper roomMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveReservation(Reservation reservation) {
        //订单状态：预订成功 -- 房型状态：已被预订
        reservation.setReservationStatus(ReservationStatus.ORDERED);
        RoomInfo room = reservation.getRoomInfo();
        room.setRoomStatus(RoomStatus.BLOCKS);
        if (roomMapper.modifyStatus(room) == 1) {
            reservationMapper.save(reservation);
            return true;
        } else {
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyReservationStatus(ReservationStatus status, Integer reservationId, Integer adminId) {
        boolean flag = false;
        Reservation reservation = reservationMapper.findById(reservationId);
        if (reservation != null) {
            reservation.setReservationStatus(status);
            //订单状态：已取消 -- 房型状态：空闲
            if (status.getStatus().equals(ReservationStatus.REVOKING.getStatus())) {
                reservation.setReservationStatus(status);
                RoomInfo room = reservation.getRoomInfo();
                room.setRoomStatus(RoomStatus.LEISURE);
                if (flag = roomMapper.modifyStatus(room) == 1) {
                    reservationMapper.updateStatus(reservation);
                }
            }
            //订单状态:已退房 -- 房型状态：空闲
            else if (status.getStatus().equals(ReservationStatus.CLEARED.getStatus())) {
                Admin admin = adminMapper.findById(adminId);
                if (admin != null) {
                    reservation.setReservationStatus(status);
                    RoomInfo room = reservation.getRoomInfo();
                    room.setRoomStatus(RoomStatus.LEISURE);
                    if (flag = roomMapper.modifyStatus(room) == 1) {
                        reservationMapper.updateStatus(reservation);
                        HistoryOrder historyOrder = new HistoryOrder();
                        historyOrder.setAdmin(admin);
                        historyOrder.setReservation(reservation);
                        historyOrder.setCheckOutDate(new Date());
                        historyOrderMapper.save(historyOrder);
                    }
                }
            }
            //订单状态：已办理入住 -- 房型状态：已被入住
            else if (status.getStatus().equals(ReservationStatus.PROCESSED.getStatus())) {
                reservation.setReservationStatus(status);
                RoomInfo room = reservation.getRoomInfo();
                room.setRoomStatus(RoomStatus.OPENED);
                if (flag = roomMapper.modifyStatus(room) == 1) {
                    reservationMapper.updateStatus(reservation);
                }
            }
        }
        return flag;
    }

    @Override
    public PageQueryResult<Reservation> listReservationByTime(String flag, Integer currentPage, Integer pageSize) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 10 : pageSize;
        List<Reservation> reservationList = null;
        if ("orderTime".equals(flag)) {
            reservationList = reservationMapper.selectListByOrderTime((currentPage - 1) * pageSize, pageSize);
        } else {
            reservationList = reservationMapper.selectListByCheckInTime((currentPage - 1) * pageSize, pageSize);
        }
        int totalRecords = reservationMapper.countReservation();
        int totalPages = (totalRecords - 1) / pageSize + 1;
        return new PageQueryResult<>(currentPage, pageSize, totalRecords, totalPages, reservationList);
    }

    @Override
    public List<Reservation> listReservationByUserId(Integer userId) {
        List<Reservation> reservationList = reservationMapper.findByUserId(userId);
        return reservationList.size() > 0 ? reservationList : Collections.emptyList();
    }


}
