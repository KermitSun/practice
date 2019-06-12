package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 22:56 2019/6/12
 * @Author: Kermit Sun
 * @Description: Java堆溢出
 */
public class HeapOOM {
    /**
     *@Date: 22:58 2019/6/12
     *@Author: Kermit Sun
     *@Description: vm： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }

    static class OOMObject{

    }
}