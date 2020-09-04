package Konu_Anlatimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BasitKomutlar {

    private WebDriver driver;
    @BeforeClass
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){

        /*
        Facebook sitesinde kullanacagimiz genel tekrar methodlari

        driver.navigate().to("Url")
        findElement(By.id())
        findElement(By.xpath())
        findElement(By.cssSelector())
        getCurrentUrl()
        if-else{}
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();

         */


        driver.get("http://google.com");
        //navigate.to() ile ikinci bir website linkine gidebiliriz
        driver.navigate().to("http://facebook.com");
        //facebook'a gidip email ve password elementslerini bulup sendKeys yapalim
        WebElement emailBox=driver.findElement(By.id("email"));
        emailBox.sendKeys("mahirbulut67@gmail.com");

        WebElement passwordBox=driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("1234g.46");

        //cssSelector de id attributeu kullandigimizda #value kullanacagiz
        WebElement loginBox=driver.findElement(By.cssSelector("#u_0_d"));
        loginBox.submit();

        //Girisimizin basarili olup olmadigina dair methoda yazalim if=else ile
        //Facebook un Url'sini alip contains() ile loginden sonuc alip ekrana yazdiracagiz
        String url=driver.getCurrentUrl();
        System.out.println(url);
        if (url.contains("http://Faceebook.com/login/")){
            System.out.println("Giris basarili");
        }else {
            System.out.println("Giris basarisiz");
        }
        driver.navigate().back();
        driver.navigate().to("http://youtube.com");
        driver.navigate().refresh();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.quit();




    }

    @Test
    public void test2(){
       /*
        Google'da arama yapip bu aramlarin sonuclarini ekrana yazdiran bir method

        */



        driver.get("http://google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("yeni Transfer");
        searchBox.submit();

        // yeni transfer aramasinda cikan sonuc toplamini ekrana yazdirmak icin
        WebElement result=driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());


    }

    @Test
    public void test3() {
        driver.get("http://gittigidiyor.com");

        String title = driver.getTitle();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(title.contains("Gittigidiyor"));
        softAssert.assertTrue(title.contains("books"));
        softAssert.assertEquals("Online", title);

        softAssert.assertAll();//Yukarida yaptigimiz  tum dogrulamalar
        //basarili ise testimiz basarii,degilse basarisiz

    }








}
