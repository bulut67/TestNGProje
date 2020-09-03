package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iframeTest  (){
        driver.get("https://the-internet.herokuapp.com/iframe");
           //  driver.switchTo().frame(index);
        driver.switchTo().frame(0);



        WebElement paragraf=driver.findElement(By.xpath("//p"));
        paragraf.clear();//iframe'in icerisini temizler
        paragraf.sendKeys("iframe'den selam");
       //driver.switchTo().frame("mce_0_ifr");//website'da olan id attributeu alip gecis yaptik
       //  driver.switchTo().frame(0);//website ki indexi 0 dan basladigi icin gecis yaptik
        //    driver.switchTo().frame(webelement seklinde);


    }

@Test
    public void iframeTest2(){
    driver.get("https://the-internet.herokuapp.com/iframe");
    // id attributeu kullanılarakta iframe'e geçiş yapabiliriz.
    driver.switchTo().frame("mce_0_ifr");
    WebElement paragraf = driver.findElement(By.xpath("//p"));
    paragraf.clear();
    paragraf.sendKeys("Merhaba Iframe");

}

    @Test
    public void iframeTest3(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // driver.switchTo().frame(webelement seklinde);
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        iframe.sendKeys("element bularak gonderdik");
    }

    @Test
    public void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // index ile iframe'e geçiş yapabiliyoruz.
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

        driver.switchTo().defaultContent();//websayfasinin ana govdesine geri doner ve
                                           //ikinci webelemeti calistirabiliriz


        WebElement element=driver.findElement(By.partialLinkText("Elemental Selenium"));
        element.click();

    }














}
