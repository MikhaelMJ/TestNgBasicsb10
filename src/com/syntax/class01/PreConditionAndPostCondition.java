package com.syntax.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PreConditionAndPostCondition {


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("выполнение перед тестом");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("выполнение после тестом");
    }
    @Test
    public void firstMethod(){
        System.out.println("первый метод");
    }

    @Test
    public void secondMethod(){
        System.out.println("второй метод");
    }
}
