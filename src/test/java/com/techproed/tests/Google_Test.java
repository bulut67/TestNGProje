package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Google_Test extends TestBase {

    @Test
    public void aramaTesti(){
        driver.get("http://google.com");
       //GooglePage class'indan bir tane nesne olusturduk. Parametre
        // olarak suan kullandigimiz driver'i gonderdik
        GooglePage googlePage=new GooglePage(driver);
        googlePage.searchBox.sendKeys("What's Up");

    }
}
