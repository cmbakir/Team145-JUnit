package Cem_Tests;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Denemeler {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //(title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        ReusableMethods.bekle(3);

        String expectedBaslik = "facebook";
        String actualBaslik = driver.getTitle();

        if (actualBaslik.equalsIgnoreCase(expectedBaslik)) {
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title testi FAILED");
            System.out.println("Site Basligi :" + actualBaslik);
        }

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //  “actual” URL’i yazdirin.
        String expectedSayfaURL = "facebook";
        String actualSayfaURL=driver.getCurrentUrl();

        if(actualSayfaURL.contains(expectedSayfaURL)) {
            System.out.println("URL Testi PASSED");
        } else {
            System.out.println("URL Testi FAILED");
            System.out.println("Sayfa URL'si :"+actualSayfaURL);
        }

        // 4.https://www.walmart.com/ sayfasina gidin.

        driver.get("https://www.walmart.com");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        String expectedBaslik2 = "Walmart.com";
        String actualBaslik2 = driver.getTitle();

        if (actualBaslik2.equalsIgnoreCase(expectedBaslik2)) {
            System.out.println("Sayfa Title testi PASSED");
        } else {
            System.out.println("Sayfa Title testi FAILED");

        }

        // 6. Tekrar “facebook” sayfasina donun

        driver.get("https://www.facebook.com");
        ReusableMethods.bekle(2);

        // 7. Sayfayi yenileyin
        driver.navigate().refresh();

        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // 9.Browser’i kapatin

        driver.quit();




    }
}
