import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date: 10:53 2019/6/27
 * @Author: BoyuSun
 * @Description:
 */
public class MyQueue {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.offer("1");
        queue.offer("2");
        queue.offer("2");
        queue.offer("3");
        queue.add("4");
        System.out.println(queue.poll());
        for (Object o : queue) {
            System.out.println(o);
        }
    }
}