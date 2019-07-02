package jvm.chapter_03;

import org.junit.jupiter.api.Test;

/**
 * @Date: 11:35 2019/6/26
 * @Author: Kermit Sun
 * @Description: 测试Eden放不下对象时候的GC以及通过担保分配到老年代的情况
 * -Xms20M -Xmx20M -Xmn10M 限制堆内存20M，不可扩展,新生代10M
 * -verbose:gc -XX:+PrintGCDetails 表示打印gc日志
 * -XX:SurvivorRatio=8 表示Eden:Survivor From:Survivor To是8:1:1大小，也就是eden分配8MB内存空间
 */
public class TestAllocation {
    private static final int _1MB = 2014*2014;

    /**
     * @Date: 11:37 2019/6/26
     * @Author: Kermit Sun
     * @Description: vm参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    private void testAllocation(){
        byte[] allo1,allo2,allo3,allo4;
        allo1 = new byte[2 * _1MB];
        allo2 = new byte[2 * _1MB];
        allo3 = new byte[2 * _1MB];
        allo4 = new byte[4 * _1MB];
    }
}