package com.syntax.class01;

import org.testng.annotations.*;

public class PreConditionAndPostCondition {

    @BeforeClass
    public void beforeClass(){
        System.out.println("перед уроком");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("после класса");
    }


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
