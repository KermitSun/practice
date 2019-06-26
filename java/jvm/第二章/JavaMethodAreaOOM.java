package jvm.第二章;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Date: 11:47 2019/6/14
 * @Author: Kermit Sun
 * @Description: 借助CGlib创建对象致使方法区出现OOM
 */
public class JavaMethodAreaOOM {

    /**
     *@Date: 13:33 2019/6/14
     *@Description:
     */

    public static void main(String[] args) {
        int i = 0;
        while(true){
            System.out.println(i++);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(HeapOOM.OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, objects);
                }
            });
            enhancer.create();
        }
    }
}