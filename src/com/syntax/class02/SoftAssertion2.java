package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertion2 {

    WebDriver driver;

    @BeforeMethod()
    public void openBrowser() {
        System.setProperty("webdriver.chrome.drivers", "drivers/chromdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vk.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void validLogin() {

        String titleActual = driver.getTitle();
        String titleExpected = "ВКонтакте | Добро пожалова";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(titleActual,titleExpected);

        WebElement email = driver.findElement(By.id("index_email"));
        email.sendKeys("dzhenkov_mihail@mail.ru");
        WebElement emailButton = driver.findElement(By.xpath("//span[text()='Войти']"));
        emailButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputCod = driver.findElement(By.xpath("//span[text()='Подтвердить другим способом']"));
        String text = inputCod.getText();
        softAssert.assertFalse(inputCod.isDisplayed());
        String expectedText = "Подтвердить";
        softAssert.assertEquals(text,expectedText);
        System.out.println("мое утверждение после всех утверждений");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testUS() {
        System.out.println("Test");
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

