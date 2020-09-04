package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {


       @Test
        public void cokluPencere(){
           driver.get("https://the-internet.herokuapp.com/windows");

           //driver'in handel'ini almak icin getWindowHandle() benzersiz id'sini almisiz demek
           //String ile return eder.
           String sayfahandle=   driver.getWindowHandle();
           System.out.println(sayfahandle);

           driver.findElement(By.partialLinkText("Click Here")).click();
           try {
               Thread.sleep(2000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }

           //bunun ile acik olan tum sayfalarin handel'larini alabiliriz
           //handeles yaparsak Bir set<lIST> seklinde verecek

           driver.getWindowHandles();
           Set<String> allPages=driver.getWindowHandles();
           for (String handle: allPages) {
               System.out.println(handle);
           }
            //"Set"'i Array'e cevirrek handle elde edebiliriz
           Object[] array = (Object[]) allPages.toArray();
           String secondPageHandle = array[array.length - 1].toString();
           System.out.println(secondPageHandle);

           //Ikinci sayfadan birinci sayfaya gecis yapar Handle ile driver.switchTo().window
            //Istediginiz handle ile gecis yapabilirsin
           driver.switchTo().window(sayfahandle);

            /*
            IKinci yol

             */



       }









}
