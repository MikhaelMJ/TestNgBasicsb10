package com.syntax.class01;

import org.testng.annotations.Test;

public class TestngClass {

    @Test()
    public void testMethod() {
        System.out.println("Это мой первый метод");
    }

    @Test()
    public void anotherMethod() {
        System.out.println("Другой метод");//если установить анотацию, этот метод не выполнится
    }

    @Test//можно без скобок
    public void lastMethod (){//тесты выполняются в алфавитном порядке названия метода
        System.out.println("последний метод");
    }
}
