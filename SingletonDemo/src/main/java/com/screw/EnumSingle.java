package com.screw;

public enum EnumSingle {
    INSTANCE;

    public static EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}
