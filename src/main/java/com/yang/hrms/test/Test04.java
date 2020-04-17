package com.yang.hrms.test;

import com.yang.hrms.util.MyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author sunyang
 * @date 2019/12/14
 */
public class Test04 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in=new FileInputStream("D:\\BaiduNetdiskDownload\\IU\\iu\\IU05.jpg");
        System.out.println(MyUtils.getHashFileName(in));

//        System.out.println(MyUtils.getFilenameSuffix("1.txt"));
    }
}
