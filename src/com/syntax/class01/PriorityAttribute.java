package com.syntax.class01;

import org.testng.annotations.Test;

public class PriorityAttribute {

    @Test(priority = 3)
    public void LoginMethod(){
        System.out.println("login method");
    }

    @Test(priority = 1)//выполняется первым
    public void launchBrowserMethod(){
        System.out.println("launch browser");
    }

    @Test(priority = 2)
    public void navigateURL(){
        System.out.println("navigate url");
    }

    @Test(priority = 4)
    public void closeBrowser(){
        System.out.println("close browser");
    }
}
