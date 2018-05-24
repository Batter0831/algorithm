package com.batter0831.test;

public class ByteTest {
    public static void main(String[] args) {
        //二进制形式的int值
        byte b = (byte)0b11111111;
        System.out.println(b);
        //byte & 0xff 可以将byte视为无符号byte
        int i = b & 0xff;
        System.out.println(i);
        //反码
        System.out.println(~b);
    }
}
