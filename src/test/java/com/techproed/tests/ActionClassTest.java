package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionClassTest extends TestBase {
    @Test
    public void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element=driver.findElement(By.id("hot-spot"));

       //Eger action class'ini kullanmak istiyorsak ,Actions nesnesini uretmek zorundayiz
        Actions actions=new Actions(driver);

        //bir webelemet'e sag tiklamak icin bu kod
        //actions class ile islem yaparsaniz,Her seferinde "PERFORM" yapmak zorundayiz
        //perform uygula ifadesi veriyor
        actions.contextClick(element).perform();

    }

    @Test
    public  void doubleClick(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

       //Bir element'e iki defa tiklamak istiyorsak doubleClick.perfom method'unu kullanabiliriz
        Actions actions=new Actions(driver);
        actions.doubleClick().perform();
    }

    @Test
    public  void hoverOver() { //mouse istegimiz element uzerine getirmek icin
        driver.get("http://amazon.com");
        WebElement menu=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        //Mouse'u istedigimiz element'in uzerine gotururuz
        actions.moveToElement(menu).perform();

    }

    @Test
    public  void sendKeys() { //asagi yukari
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();

    }

}
