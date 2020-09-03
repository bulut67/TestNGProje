package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeClass
    public  void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        String title=driver.getTitle();

        SoftAssert softAssert =new SoftAssert();
        softAssert.assertFalse(title.contains("Amazon"));
        softAssert.assertTrue(title.contains("Car"));
        softAssert.assertEquals("Online",title);

        softAssert.assertAll();//Yukarida yaptigimiz  tum dogrulamalar
                               //basarili ise testimiz basarii,degilse basarisiz

    }


    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert=new SoftAssert();


        WebElement emailBox=driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordBox=driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");

        WebElement signinButton=driver.findElement(By.name("commit"));
        signinButton.click();


        WebElement signOutbutton=driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyorMu=signOutbutton.isDisplayed();

        //Assert.assertTrue(gorunuyorMu);
        softAssert.assertAll();

    }
}
