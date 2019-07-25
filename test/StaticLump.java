/**
 * @Date: 14:36 2019/7/25
 * @Author: BoyuSun
 * @Description: 静态代码块在jvm初始化时候按顺序收集
 */
public class StaticLump {
    static int i;
    static{
        //static块能为所有static变量赋值，但是只能访问static块之前的变量
        i=3;
        System.out.println(i);
        j=4;
        //System.out.println(j);
    }
    static int j;
}