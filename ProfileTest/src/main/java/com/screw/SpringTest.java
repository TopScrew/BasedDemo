package com.screw;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTest.class)
@ComponentScan(basePackages = {"com.screw"})
@ActiveProfiles("prd")
public class SpringTest {

    @Autowired
    Person p;

    @Test
    public void testProfile(){
        p.speak();
    }

}

