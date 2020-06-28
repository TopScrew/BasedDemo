package com.screw;

//懒汉式单例
public class Lazy {

    private Lazy(){
        System.out.println(Thread.currentThread().getName());
    }

    private static  Lazy lazy;

    public static Lazy getInstance(){
        if(null == lazy){
            lazy = new Lazy();
        }
        return lazy;
    }

    //单线程下确实是没有问题的，多线程就会出问题
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
           new Thread(()->{
                Lazy.getInstance();
           }).start();
        }
    }
}
