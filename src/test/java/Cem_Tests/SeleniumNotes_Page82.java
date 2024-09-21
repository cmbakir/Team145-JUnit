package Cem_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class SeleniumNotes_Page82 extends TestBase_Each {


    //1- testotomasyonu.com anasayfasina gidelim
    //2- arama kutusunu locate edelim
    //3- “phone” ile arama yapalim
    //4- Bulunan sonuc sayisini yazdiralim
    //5- Ilk urunu tiklayalim
    //6- Urunun stokta var oldugunu test edin

   @Test
 public void test01(){
       //1- testotomasyonu.com anasayfasina gidelim
       driver.get("http://www.testotomasyonu.com");

       //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

       //3- “phone” ile arama yapalim
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
       //5- Ilk urunu tiklayalim
         driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]"))
                 .click();
       //6- Urunun stokta var oldugunu test edin
       String expectedUrunYazisi ="In Stock";

       String actualUrunYazisi = driver.findElement(By.xpath("//*[text()='In Stock']")).getText();

       if(expectedUrunYazisi.equalsIgnoreCase(actualUrunYazisi)) {
           System.out.println("Urun Stok Testi PASSED");
       }
       ////*[text()='In Stock']





   }


}
