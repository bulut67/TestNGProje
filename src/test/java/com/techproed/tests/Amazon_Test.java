package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class Amazon_Test extends TestBase {


    @Test
    public void aramaTest(){
        driver.get("http://amazon.com");
        AmazonPage amazonPage=new AmazonPage(driver);
        amazonPage.searchBox.sendKeys("Iphone 7plus");
    }



}
