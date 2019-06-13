package jvm;

/**
 * @Date: 10:42 2019/6/13
 * @Author: BoyuSun
 * @Description: 虚拟机栈和本地方发栈OOM测试
 */
public class JavaVMStackSOF {
    private int stackLenght = 1;

    public void stackLeak(){
        stackLenght++;
        stackLeak();
    }

    /**
     *@Date: 10:45 2019/6/13
     *@Author: Kermit Sun
     *@Description: vm： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch(Throwable e){
            System.out.println("stack length:" + sof.stackLenght);
            throw e;
        }
    }
}