package jvm.第三章;

import org.junit.jupiter.api.Test;

/**
 * @Date: 16:17 2019/6/26
 * @Author: Kermit Sun
 * @Description: 测试分配担保开关打开和关上的情况
 */
public class TestHandlePromotionFailure {
    private static final int _1MB = 2014*2014;

    /**
     * @Date:  16:17
     * @Description:
     * vm1参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
     * vm2参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    private void testHandlePromotionFailure(){
        byte[] allo1,allo2,allo3,allo4,allo5,allo6,allo7;
        allo1 = new byte[2 * _1MB];
        allo2 = new byte[2 * _1MB];
        allo3 = new byte[2 * _1MB];
        allo1 = null;
        allo4 = new byte[2 * _1MB];
        allo5 = new byte[2 * _1MB];
        allo6 = new byte[2 * _1MB];
        allo4 = null;
        allo5 = null;
        allo6 = null;
        allo7 = new byte[2 * _1MB];
    }
}