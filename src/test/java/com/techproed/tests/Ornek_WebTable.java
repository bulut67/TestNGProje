package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {


    public  void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        WebElement userNameButton=driver.findElement(By.id("UserName"));
        userNameButton.sendKeys("manager2");

        WebElement passwordBox=driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!");

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();



    }
    @Test
    public void test(){

        giris();

        /*
        1-Tbody icerisinde ki tr olan tum elementleri bulur ve size ile sayisi vardir
         */
        List<WebElement> Satirlar= driver.findElements(By.xpath("//tbody/tr"));

        System.out.println("Tabloda "+Satirlar.size()+" tane vardir");

        // 3 uncu satirda ki elemanlari ekrana yazdirir
        WebElement ucuncusatir=driver.findElement(By.xpath("//tbody/tr[3]"));
        System.out.println(ucuncusatir.getText());




    }


}
