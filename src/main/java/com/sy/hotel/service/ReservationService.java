package com.sy.hotel.service;

import com.sy.hotel.domain.Reservation;
import com.sy.hotel.dto.PageQueryResult;
import com.sy.hotel.enums.ReservationStatus;

import java.util.List;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/3/19
 * 预订订单业务
 */
public interface ReservationService {

    boolean saveReservation(Reservation reservation);

    boolean modifyReservationStatus(ReservationStatus status, Integer reservationId, Integer adminId);

    PageQueryResult<Reservation> listReservationByTime(String flag, Integer currentPage, Integer pageSize);

    List<Reservation> listReservationByUserId(Integer userId);
}
