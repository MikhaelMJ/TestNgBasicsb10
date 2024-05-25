package com.syntax.class02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion1 {
    @Test(groups = "smoke1")
    public void softAssertionVal(){
        String expected = "Bla bla bla";
        String actual = "BlaBlaBla";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expected, actual);
        System.out.println("мой код после первого утвердждения");

        softAssert.assertTrue(false);
        System.out.println("мой код после 2 утвердждения");

        softAssert.assertFalse(true);
        System.out.println("мой код после 3 утвердждения");

        softAssert.assertFalse(false);
        System.out.println("мой код после 4 утвердждения");

        String newExpected = "This is last one";
        String newActual = "This is last one";
        softAssert.assertEquals(newExpected, newActual);

        //чтобы собрать всю информацию об утверждениях
        // это утверждение должно быть последним в тесте
        softAssert.assertAll();
    }
}
