package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
        //bos bir tane driver degiskeni olusturduk
        WebDriver driver;
        public  GooglePage(WebDriver driver){
            /*
            Parametre olarak gelen driver nesnesini, bu class;ta create
          driver nesnesine esledik,Bu sekilde yeniden bos bir driver olusturmak yerine,
          zaten halihazirda kullandigimiz driver'i bu nesne ile esitlemis olduk
             */
            this.driver=driver;
            //birazdan bulacagimiz elementleri hazir hale getirdik
            PageFactory.initElements(driver,this);
         }
        @FindBy(name="q")
        public WebElement searchBox;

}
