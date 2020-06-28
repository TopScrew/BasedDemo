package com.screw;

//饿汉式单例
public class Hunger {

    //要点是构造器私有，外部无法new
    private Hunger(){

    }

    private final static Hunger HUNGER = new Hunger();


    //缺点是可能是浪费空间，不管用不用都会创造空间
    public  static   Hunger getInstance(){
        return HUNGER;
    }
}
