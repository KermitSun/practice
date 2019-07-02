package jvm.chapter_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Date: 15:47 2019/7/2
 * @Author: BoyuSun
 * @Description: JConsole线程监控
 */
public class ThreadMonitoring {

    /**
     * @Date:  15:52
     * @Description: 死循环线程,该线程处于Runnable状态
     */
    public static void createBusyThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        },"BusyThread").start();
    }

    /**
     * @Date:  16:14
     * @Description: 线程处于WAITING状态，证明wait()会释放锁
     */
    public static void createWaitingThread(){
        new Thread(new LockWaitThread(),"WaitThread1").start();
        new Thread(new LockWaitThread(),"WaitThread2").start();
    }

    /**
     * @Date:  16:25
     * @Description: SleepThread1处于BLOCKED状态， SleepThread2处于TIMED_WAITING状态等待锁，过1h后可恢复运行
     */
    public static void createSleepThread(){
        new Thread(new LockSleepThread(), "SleepThread1").start();
        new Thread(new LockSleepThread(), "SleepThread2").start();
    }
    private final static String waitKey = "wait";
    private static class LockWaitThread implements Runnable{
        @Override
        public void run() {
            synchronized (waitKey){
                try {
                    waitKey.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class LockSleepThread implements Runnable{
        @Override
        public void run() {
            synchronized ("sleep"){
                try {
                    //睡半分钟
                    Thread.sleep(1000*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @Date:  16:14
     * @Description: 死锁，线程处于BLOCKED状态
     */
    public static void createDeadLockThread(){
        new Thread(new DeadLockThread(1,2), "DeadLockThread1").start();
        new Thread(new DeadLockThread(2,1), "DeadLockThread2").start();
    }
    private static class DeadLockThread implements Runnable{
        int a,b;
        public DeadLockThread(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                try {
                    Thread.sleep(1000);
                    synchronized (Integer.valueOf(b)){
                        System.out.println(a+b);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //InputStream in = System.in;
        //InputStreamReader inputStreamReader = new InputStreamReader(in);
        //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //bufferedReader.readLine();
        createBusyThread();
        //bufferedReader.readLine();
        createWaitingThread();
        createSleepThread();
        createDeadLockThread();
    }
}