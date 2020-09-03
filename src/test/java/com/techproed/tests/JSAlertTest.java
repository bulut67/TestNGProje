package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsAlert()">Click for JS Alert</button>

        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        //alert'in icerdigi mesaji almak icin kullaniriz gettext()
       String alertmesaji= driver.switchTo().alert().getText();
        System.out.println(alertmesaji);

        //Alert'in icerisinde ki okey butonuna tiklamak icin kullanilir
        driver.switchTo().alert().accept();


    }

    @Test
    public void jsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement confirmButton=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmButton.click();

        //icerdigi mesaji ekrana yazdirmak icin
        String confirmmesaji=driver.switchTo().alert().getText();
        System.out.println(confirmmesaji);

        //okey butonu icin
        driver.switchTo().alert().accept();
    }



    @Test
    public void jspromot(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsPrompt()">Click for JS Prompt</button>

        WebElement promotbutton=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promotbutton.click();


        String promtmesaji=driver.switchTo().alert().getText();
        System.out.println(promtmesaji);


    }







}
