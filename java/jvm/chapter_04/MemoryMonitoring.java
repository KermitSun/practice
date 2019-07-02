package jvm.chapter_04;

import java.util.ArrayList;

/**
 * @Date: 15:27 2019/7/2
 * @Author: BoyuSun
 * @Description: JConsole内存监控
 */
public class MemoryMonitoring {
    public static final int _64KB = 64 * 1024;
    static class OOMObject{
        public byte[] placeholder = new byte[_64KB];
    }

    //填充到内存
    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
            System.out.println(i);
        }
        System.gc();
    }

    /**
     * @Date:  15:32
     * @Description: VM:-Xms100M -Xmx100M -XX:+UseSerialGC
     * 以64KB/50ms的速度往Java堆里填充数据，填充一千次
     */
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}