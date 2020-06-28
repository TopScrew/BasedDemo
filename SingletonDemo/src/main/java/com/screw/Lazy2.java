package com.screw;

import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.lang.reflect.Constructor;

public class Lazy2 {

    private Lazy2(){
        System.out.println(Thread.currentThread().getName());
    }
    //避免指令重排
    private volatile static  Lazy2 lazy;

    //双重检测锁模式
    public static Lazy2 getInstance(){
        if(null == lazy){
            synchronized (Lazy2.class){
                if(null == lazy){
                    lazy = new Lazy2();  //非原子操作
                }
            }
        }

        return lazy;
    }

    //单线程下确实是没有问题的，多线程就会出问题
    public static void main(String[] args) throws Exception {
       Lazy2 instance = Lazy2.getInstance();
       Constructor<Lazy2> declaredConstructor = Lazy2.class.getDeclaredConstructor(null);
       declaredConstructor.setAccessible(true);
        Lazy2 instance2 =declaredConstructor.newInstance();
       System.out.println(instance.hashCode());
       System.out.println(instance2.hashCode());
    }
}
