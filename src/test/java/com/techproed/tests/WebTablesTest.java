package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;

public class WebTablesTest extends TestBase {




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
    public void table(){

       giris();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement tbody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

     List<WebElement>basliklar= driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement w: basliklar){
            System.out.println(w.getText());
        }

    }

    @Test
    public  void tumSatirlar(){
        giris();

        List<WebElement>tumSatirlar=driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w: tumSatirlar){
            System.out.println(w.getText());
        }


        List<WebElement>tumhucreler=driver.findElements(By.xpath("//tbody/tr/td"));
       for (WebElement q:tumhucreler) {
            System.out.println(q.getText());
        }

    }

    @Test
    public void belirliBirSutunYazdirma(){
        //  //tbody/tr/td[4] 4. sutun'u yazdiriyoruz
        giris();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement>dorduncuSutun=driver.findElements(By.xpath("//tbody/tr/td[4]"));
        for (WebElement q:dorduncuSutun) {
            System.out.println(q.getText());
        }

        driver.quit();
    }

    @Test
    public void calistir(){
        giris();
        hucreYazdir(3,5);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public void hucreYazdir(int satir , int sutun){
       // "//tbody/tr[4]/td[6]";
        String xpathDegeri="//tbody/tr["+satir +"]/td["+ sutun +"]";
        WebElement hucre=driver.findElement(By.xpath(xpathDegeri));
        System.out.println(hucre.getText());

    }
}
