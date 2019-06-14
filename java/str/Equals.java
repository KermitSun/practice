package str;

/**
 * @Date: 10:55 2019/6/14
 * @Author: BoyuSun
 * @Description:
 */
public class Equals {
    public static void main(String[] args) {
        Equals e = new Equals();
        e.test1();
        System.out.println("=======================");
        e.test2();
    }

    /**
     *@Date: 11:02 2019/6/14
     *@Description: new String返回的是堆的指针，tring x ="x"也是返回常量池的指针
     * intern返回的在jdk6和jdk7中表现不一样
     * jdk6中返回常量池指针
     * jdk7中会判断常量池中有没有，有的话直接返回常量池指针，没有的话在常量池中保存对象的引用，然后返回对象的引用
     */
    private void test1(){
        String a = new String("x");
        String b = new String("x");
        String c = "x";
        System.out.println(a == b);
        System.out.println(a.intern() == b);
        System.out.println(a.intern() == b.intern());
        System.out.println(a.intern() == c);
        System.out.println(a.intern() == "x");
    }

    /**
     *@Date: 11:02 2019/6/14
     *@Description: 此段代码在jdk6和jdk7将会有不同返回
     */
    private void test2(){
        String str1 = new StringBuffer("x").append("y").toString();
        System.out.println(str1 == str1.intern());
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2 == str2.intern());
    }
}