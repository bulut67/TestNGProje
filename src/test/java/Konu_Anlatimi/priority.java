package Konu_Anlatimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class priority {
    WebDriver driver;
    @BeforeClass
    public  void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    //priority ler olmadan test yazildiginda testler yukaridan asagi'ya dogru test etmeye baslar
    // ama biz priority kullanarak hangi testimizin ne zaman baslayacagina karar verebiliriz

    @Test  (priority = 3)
    public void test1(){
        driver.get("http://amazon.com");

    }

    @Test (priority = 1)
    public void test2(){
        driver.get("http://facebook.com");
    }

    @Test  (priority = 2)
    public void test3(){
        driver.get("http://Youtube.com");

    }


}
