import java.util.Arrays;

/**
 * @Date: 16:50 2019/7/23
 * @Author: BoyuSun
 * @Description: for循环边界判断
 */
public class ForTest {
    public static void main(String[] args) {
        for(int i=0;i<get();i++){
            System.out.println(i);
        }
        System.out.println("over");
    }


    public static int get(){
        System.out.println("---");
        return 10;
    }
}