package Cem_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_SuleymanVarolTest {

    public static void main(String[] args) {

       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("user-data-dir=C:/path/to/your/custom/profile");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //(title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        ReusableMethods.bekle(3);

        WebElement baslikIsmiElementi=driver.findElement(By.id("pageTitle"));
        String expektedBaslikIsmi="facebook";
        String actualBaslikIsmi=baslikIsmiElementi.getText().toLowerCase();

        if (actualBaslikIsmi.equalsIgnoreCase(expektedBaslikIsmi)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
            System.out.println("Title ismi: "+actualBaslikIsmi+" dir");
        }

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //  “actual” URL’i yazdirin.
        String actuelsayfaUrlsi=driver.getCurrentUrl();
        String expectedSayfaUrlsi="https://www.facebook.com";

        if (actuelsayfaUrlsi.contains(expectedSayfaUrlsi)){
            System.out.println("Url testi PASSED");
        }else{
            System.out.println("Url testi FAILED");
            System.out.println("Url ismi: "+actuelsayfaUrlsi+" dir");
        }

        // 4.https://www.walmart.com/ sayfasina gidin.

        driver.get("https://www.walmart.com");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        WebElement baslikElementi=driver.findElement(By.tagName("h1"));

        String expektedBaslik="walmart.com";
        String actualBaslik=baslikElementi.getText().toLowerCase();

        if (actualBaslik.contains(expektedBaslik)){
            System.out.println("isim2 testi PASSED");
        }else{
            System.out.println("isim2 testi FAILED");
            System.out.println(" ismi : "+actualBaslik+" dir");
        }

        // 6. Tekrar “facebook” sayfasina donun

        driver.get("https://www.facebook.com");
        ReusableMethods.bekle(1);
        // 7. Sayfayi yenileyin
        driver.get(driver.getCurrentUrl());
        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // 9.Browser’i kapatin










        ReusableMethods.bekle(3);
        driver.quit();
    }
}

