package com.sy.hotel.service;

import com.sy.hotel.enums.ReservationStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunyang
 * @date 2018/5/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    public void modifyReservationStatus(){
        Assert.assertTrue(reservationService.modifyReservationStatus(
                ReservationStatus.CLEARED,
                14,
                1
        ));
    }
}
