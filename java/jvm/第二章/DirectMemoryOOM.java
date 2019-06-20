package jvm.第二章;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Date: 11:59 2019/6/20
 * @Author: BoyuSun
 * @Description: 本机内存直接溢出
 */
public class DirectMemoryOOM {
    private static final int _1MB =1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true){
            //分配1MB本机内存
            unsafe.allocateMemory(_1MB);
        }
    }
}