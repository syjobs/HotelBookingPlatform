package com.yang.hrms.service;

import com.yang.hrms.domain.Reservation;
import com.yang.hrms.dto.PageQueryResult;
import com.yang.hrms.enums.ReservationStatus;

import java.util.List;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/3/19
 * 预定订单业务
 */
public interface ReservationService {

    boolean saveReservation(Reservation reservation);

    boolean modifyReservationStatus(ReservationStatus status, Integer reservationId, Integer adminId);

    PageQueryResult<Reservation> listReservationByTime(String flag, Integer currentPage, Integer pageSize);

    List<Reservation> listReservationByUserId(Integer userId);
}
