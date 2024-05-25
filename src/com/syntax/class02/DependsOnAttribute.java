package com.syntax.class02;

import org.testng.annotations.Test;

public class DependsOnAttribute {
    @Test
    public void login(){
        System.out.println("login method");
    }

    @Test(dependsOnMethods = "login")//зависит от метода логин
    public void verifyDashboardPage(){
        System.out.println("dashboard page");
    }

    @Test(dependsOnMethods = {"login", "verifyDashboardPage"})//зависит от метода логин и метода страницы панели
    public void verifyLogout(){
        System.out.println("logout page");
    }


}
