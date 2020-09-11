package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateHotel extends TestBase {


    @BeforeMethod
    public  void girisTest(){
        //a. Username : manager2
        //b. Password : Man1ager2!
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");

        WebElement userNameButton=driver.findElement(By.id("UserName"));
        userNameButton.sendKeys("manager2");

        WebElement passwordBox=driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!");

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }










    @Test
    public void room(){



        WebElement codeBox=driver.findElement(By.id("Code"));
        codeBox.sendKeys("V0123");

        WebElement nameBox=driver.findElement(By.name("Name"));
        nameBox.sendKeys("mahir");

        WebElement adressBox=driver.findElement(By.id("Address"));
        adressBox.sendKeys("Greece");

        WebElement phoneBox=driver.findElement(By.id("Phone"));
        phoneBox.sendKeys("+123444455");

        WebElement emailBox=driver.findElement(By.id("Email"));
        emailBox.sendKeys("hey@selenium.com");


        WebElement idGroupButton=driver.findElement(By.id("IDGroup"));


        Select select= new Select(idGroupButton);
        select.selectByIndex(2);

        WebElement saveButton=driver.findElement(By.id("btnSubmit"));
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveButton.click();


        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement basariliYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));


        Assert.assertTrue(basariliYazisi.isDisplayed());
        driver.quit();






    }

}
