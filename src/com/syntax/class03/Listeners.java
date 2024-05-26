package com.syntax.class03;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public void onTestStart(ITestResult result){
        System.out.println("Listener Starting test with the name: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Listener Тест прошел успешно, сделайте скриншот");
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Listener тест пропущен " + result.getName());
    }

    public void onTestFail(ITestResult result){
        System.out.println("Listener тест провален "+ result.getName());
    }

    public void onStart(ITestContext context){

    }


}
