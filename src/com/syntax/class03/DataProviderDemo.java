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

import java.time.Duration;

public class DataProviderDemo {

    WebDriver driver;
    //когда тестируется с разными учетными данными (логин, пароль)
    /*@DataProvider
    public Object[][] loginData(){
        Object[][] data = new Object[3][2]; //3 строки, 2 столбца
        data[0][0]="Admin";
        data[0][1]="21659";
        data[1][0]="Admin";
        data[1][1]="21659";
        data[2][0]="Admin";
        data[2][1]="21659";
        return data;
    }*/

    //в данном случае есть только логин
    @DataProvider //поставщик данных
    public Object[][] loginData() {
        Object[][] data = new Object[3][1];
        data[0][0] = "dzhenkov_mihail@mail.ru";
        data[1][0] = "Chernikova_nina-@mail.ru";
        data[2][0] = "dzhenkov_mihail@mail.ru";
        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.drivers", "drivers/chromdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vk.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(dataProvider = "loginData")
    public void validLogin(String username) {

       /* String titleActual = driver.getTitle();
        String titleExpected = "ВКонтакте | Добро пожалов/

        /*SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(titleActual,titleExpected);*/

        WebElement email = driver.findElement(By.id("index_email"));
        email.sendKeys(username);
        WebElement emailButton = driver.findElement(By.xpath("//span[text()='Войти']"));
        emailButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*WebElement inputCod = driver.findElement(By.xpath("//span[text()='Подтвердить другим способом']"));
        String text = inputCod.getText();
        softAssert.assertFalse(inputCod.isDisplayed());
        String expectedText = "Подтвердить";
        softAssert.assertEquals(text,expectedText);
        System.out.println("мое утверждение после всех утверждений");
        softAssert.assertAll();*/
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}