package jvm.第二章;

import java.util.ArrayList;

/**
 * @Date: 11:13 2019/6/14
 * @Author: Kermit Sun
 * @Description: 运行时常量池导致的内存溢出异常
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int i=0;
        while(true){
            list.add(""+i);
        }
    }
}