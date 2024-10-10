package Cem_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TO extends TestBase_Each {

    List<WebElement> bulunanUrunElementleriList;

    @Test
    public void test17() {

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method’larini kullanarak
        //   “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin


        driver.get("https://testotomasyonu.com");
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).sendKeys("dress").perform();
        ReusableMethods.bekle(1);

        // aramaKutusu.sendKeys("phone" + Keys.ENTER );

         actions.sendKeys(Keys.ENTER).perform();
     //   List<WebElement> bulunanUrunElementleriList;

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@class='prod-img']"));



        for (WebElement eachElement : bulunanUrunElementleriList) {

            if (eachElement.getText().contains("Partywear")) {
                System.out.println(eachElement + "bulundu ve arama testi PASSED");
            } else System.out.println(eachElement + "bulunamadi ve arama testi FAILED");



            System.out.println(eachElement);
            ReusableMethods.bekle(2);
            driver.quit();
        }

    }
}



