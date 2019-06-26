package jvm.第三章;

import org.junit.jupiter.api.Test;

/**
 * @Date: 15:20 2019/6/26
 * @Author: Kermit Sun
 * @Description: 测试超过-XX:PretenureSizeThreshold的值直接进入老年代
 * -XX:PretenureSizeThreshold=3145728 指定超过3MB的对象直接进入老年代
 */
public class TestPretenureSizeThreshold {
    private static final int _1MB = 2014*2014;

    /**
     * @Date:  15:17
     * @Author: Kermit Sun
     * @Description: vm参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    @Test
    private void testPretenureSizeThreshold(){
        byte[] allo;
        allo = new byte[4 * _1MB];//将直接分配到老年代之中
    }
}