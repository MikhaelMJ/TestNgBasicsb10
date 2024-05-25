package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assertion {

    WebDriver driver;

    @BeforeMethod()
    public void openBrowser() {
        System.setProperty("webdriver.chrome.drivers", "drivers/chromdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vk.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }



    @Test(priority = 1,enabled = true)
    public void validLogin() throws InterruptedException {
        WebElement email = driver.findElement(By.id("index_email"));
        email.sendKeys("dzhenkov_mihail@mail.ru");
        WebElement emailButton = driver.findElement(By.xpath("//span[text()='Войти']"));
        emailButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputCod = driver.findElement(By.xpath("//span[text()='Подтвердить другим способом']"));
        if (inputCod.isDisplayed()){
            System.out.println("email valid");
        }else {
            System.out.println("email invalid");
        }
    }

    @Test(priority = 2, enabled = true)
    public void validationOfTitle(){
        String actualValue = "ВКонтакте | Добро пожалова";
        String expectedText = driver.getTitle();
        System.out.println(expectedText);

        Assert.assertEquals(actualValue, expectedText); //жесткое утверждение
        System.out.println("Выполнение после утверждения");// строка не выполниться
    }
}
