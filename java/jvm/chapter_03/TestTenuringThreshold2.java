package jvm.chapter_03;

import org.junit.jupiter.api.Test;

/**
 * @Date: 15:53 2019/6/26
 * @Author: Kermit Sun
 * @Description: 测试动态对象年龄判定
 */
public class TestTenuringThreshold2 {
    private static final int _1MB = 2014*2014;

    /**
     * @Date:  15:39
     * @Description: vm1参数：vm参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     */
    @Test
    private void testTenuringThreshold2(){
        byte[] allo1,allo2,allo3,allo4;
        allo1 = new byte[_1MB / 4];
        allo2 = new byte[_1MB/4];
        //allo1+allo2的空间大于等于Survivor空间的一半，触发动态年龄判断，进入老年代
        allo3 = new byte[4 *_1MB];
        allo4 = new byte[4 *_1MB];
        allo4 = null    ;
        allo4 = new byte[4 *_1MB];
    }
}