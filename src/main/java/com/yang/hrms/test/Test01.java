package com.yang.hrms.test;

import com.yang.hrms.enums.ReservationStatus;

/**
 * @author sunyang
 * @date 2019/12/5
 */
public class Test01 {
    public static void main(String[] args) {
        int index= ReservationStatus.ORDERED.ordinal();
        System.out.println(index);
        System.out.println(ReservationStatus.ORDERED.getStatus());
    }
}
