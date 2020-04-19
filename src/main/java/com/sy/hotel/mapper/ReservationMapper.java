package com.sy.hotel.mapper;

import com.sy.hotel.domain.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/5
 * 预订订单的数据接口
 */
public interface ReservationMapper {

    int save(Reservation reservation);

    int updateStatus(Reservation reservation);

    Reservation findById(Integer id);

    List<Reservation> findByUserId(Integer userId);

    Integer countReservation();

    List<Reservation> selectListByOrderTime(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    List<Reservation> selectListByCheckInTime(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
