package jvm.第三章;

import org.junit.jupiter.api.Test;

/**
 * @Date: 15:36 2019/6/26
 * @Author: Kermit Sun
 * @Description: 测试-XX:MaxTenuringThreshold = 1 和 15 时候gc的区别
 * -XX:MaxTenuringThreshold 标识age为多少时候进入老年代
 */
public class TestTenuringThreshold {
    private static final int _1MB = 2014*2014;

    /**
     * @Date:  15:39
     * @Description:
     * vm1参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * vm2参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     */
    @Test
    private void testTenuringThreshold(){
        byte[] allo1,allo2,allo3;
        allo1 = new byte[_1MB / 4];
        allo2 = new byte[4 *_1MB];
        allo3 = new byte[4 *_1MB];
        allo3 = null    ;
        allo3 = new byte[4 *_1MB];
    }
}