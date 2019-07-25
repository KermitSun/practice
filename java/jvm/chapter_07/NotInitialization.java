package jvm.chapter_07;
import	java.net.Socket;

/**
 * @Date: 15:03 2019/7/15
 * @Author: BoyuSun
 * @Description: 验证类加载
 */
public class NotInitialization {
    public static void main(String[] args) {
        //不会输出sub class init
        System.out.println(SubClass.value);
        System.out.println("-------------------");
        //数组类型不会初始化该类
        SubClass[] subClasses = new SubClass[10];
        //final常量会加载到常量池，所以不对类进行初始化
        System.out.println(ConstClass.HELLOWORLD);
    }
}

class SubClass extends SuperClass{
    static{
        System.out.println("sub class init");
    }
}

class SuperClass extends SuperSuperClass{
    static{
        System.out.println("super class init!");
    }
    static int value = 1;
}

class SuperSuperClass{
    static{
        System.out.println("super 's super class init");
    }
}

class ConstClass{
    static {
        System.out.println("const class init");
    }
    public static final String HELLOWORLD = "hello world!";
}