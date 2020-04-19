package com.sy.hotel.test;

/**
 * @author sunyang
 * @date 2019/12/6
 * 正则表达式的验证
 */
public class Test02 {
    public static void main(String[] args) {
        Long startTime=System.currentTimeMillis();
//        String str="sdgrte";
//        String regex="\\w{6,18}";
//        System.out.println(str.matches(regex));

//        String str="sdgrte7,.8d-=+%*&#$5454545454545";
//        String regex="(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[!@#$%^&*? ]+$).{8,32}";
//        System.out.println(str.matches(regex));

        String str="18308461767";
        String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,3,5-9]))\\d{8}$";
        System.out.println(str.matches(regex));

        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
