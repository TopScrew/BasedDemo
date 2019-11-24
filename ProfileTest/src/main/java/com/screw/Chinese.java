package com.screw;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile(value = "dev")
@Component
public class Chinese implements MoveFactor {
    @Override
    public void speak() {
        System.out.println("我是中国人");
    }
}

