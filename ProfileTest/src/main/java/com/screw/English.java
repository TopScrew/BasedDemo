package com.screw;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prd")
public class English implements MoveFactor{
    @Override
    public void speak() {
        System.out.println("i am an English");
    }
}

