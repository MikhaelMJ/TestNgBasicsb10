package com.syntax.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Groupings {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @Test(groups = {"smoke"})
    public void testMethod() {
        System.out.println("Это мой первый метод");
    }

    @Test(groups = {"smoke"})
    public void anotherMethod() {
        System.out.println("Другой метод");//если не установить анотацию, этот метод не выполнится
    }

    @Test(groups = {"regression"})
    public void lastMethod (){//тесты выполняются в алфавитном порядке названия метода
        System.out.println("последний метод");
    }
}
