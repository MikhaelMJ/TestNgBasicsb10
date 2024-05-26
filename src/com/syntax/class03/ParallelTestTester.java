package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class ParallelTestTester extends CommonMethods {



    @DataProvider //поставщик данных
    public Object[][] loginData() {
        Object[][] data = new Object[1][1];
        data[0][0] = "dzhenkov_mihail@mail.ru";
        return data;
    }




    @Test()
    public void validLogin() {



        SoftAssert softAssert = new SoftAssert();


        WebElement email = driver.findElement(By.id("index_email"));

        email.sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement emailButton = driver.findElement(By.xpath("//span[text()='Войти']"));
        emailButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputCod = driver.findElement(By.xpath("//span[text()='Подтвердить другим способом']"));
        String text = inputCod.getText();
        softAssert.assertFalse(inputCod.isDisplayed());

    }

    @Test()
    public void validLogin2() {


        WebElement email = driver.findElement(By.id("index_email"));

        email.sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement emailButton = driver.findElement(By.xpath("//span[text()='Войти']"));
        emailButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    }

