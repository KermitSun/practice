package jvm.chapter_03;

/**
 * @Date: 16:44 2019/6/20
 * @Author: Kermit Sun
 * @Description: 此代码展示了两点
 * 1.对象可以在GC时候被回收
 * 2.这种自救只会成功一次，因为一个对象的finalize()只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("Yes, i am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象的第一次成功拯救自己
        gc();

        //第二次自救失败
        gc();
    }

    private static void gc() throws InterruptedException {

        SAVE_HOOK = null;
        System.gc();
        //finalize方法的优先级很低，等待0.5s待它执行
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead!");
        }
    }
}