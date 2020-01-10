package com.liz.incubator;

import com.liz.incubator.controller.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lizhou on 2016/5/24
 *
 * Unit test demo in  spring boot project
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseJunitTest {

    @Test
    public void demoTest(){
        System.out.println("UnitTestDemo.demoTest() is running ...");
        Assert.assertNotNull("hello");
        System.out.println("UnitTestDemo.demoTest() has ran ...");
    }
}
