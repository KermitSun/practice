package jvm.chapter_02;

/**
 * @Date: 11:14 2019/6/13
 * @Author: Kermit Sun
 * @Description: 创建线程导致内存溢出
 * Java的线程在操作系统内核上工作，该代码可能会导致系统死机
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while(true){}
    }

    public void stackLeakByThread(){
        while(true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}