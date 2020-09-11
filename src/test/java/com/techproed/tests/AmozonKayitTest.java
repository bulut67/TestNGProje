package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmozonKayitTest extends TestBase {

    @Test
    public void test(){
        driver.get("http://amazon.com");
        WebElement menu=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        //Mouse'u istedigimiz element'in uzerine gotururuz
        actions.moveToElement(menu).perform();

        WebElement startHere = driver.findElement(By.partialLinkText("Start here"));
        startHere.click();
        String title=driver.getTitle();
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(title.contains("Amazon Registration"));

        softAssert.assertAll();
        driver.quit();

    }
    @Test
    public void test2(){
        driver.get("http://amazon.com");
        WebElement menu=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        //Mouse'u istedigimiz element'in uzerine gotururuz
        actions.moveToElement(menu).perform();

        WebElement startHere = driver.findElement(By.partialLinkText("Start here"));
        startHere.click();

        WebElement nameBox=driver.findElement(By.id("ap_customer_name"));
        nameBox.sendKeys("Mahir Bulut");

        WebElement emailBox=driver.findElement(By.id("ap_email"));
        emailBox.sendKeys("mahir67@gmail.com");

        WebElement passwordBox=driver.findElement(By.name("password"));
        passwordBox.sendKeys("12345512");

        WebElement passwordBox2=driver.findElement(By.id("ap_password_check"));
        passwordBox2.sendKeys("12345512");

        WebElement createBox=driver.findElement(By.id("continue"));
        createBox.click();
    }
}
