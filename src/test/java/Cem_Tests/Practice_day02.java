package Cem_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass2;

public class Practice_day02 extends TestBaseClass2 {



    //1- http://www.testotomasyonu.com anasayfasina gidelim
    //2- arama kutusunu locate edelim
    //3- “phone” ile arama yapalim
    //4- Ilk urunu tiklayalim
    //5- Urunun stokta var oldugunu test edin

    @Test
    public void test01(){
        //1- testotomasyonu.com anasayfasina gidelim
        driver.get("http://www.testotomasyonu.com");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));

        //aramaKutusu.click();

        //3- “phone” ile arama yapalim
        aramaKutusu.sendKeys("phone"  + Keys.ENTER);

       driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
               .click();
       //5- Urunun stokta var oldugunu test edin

        String exceptedUrunStokYazisi= "In Stock";
        String actualUrunYazisi =driver.findElement(By.xpath("//*[text()='In Stock']")).getText();

        if(exceptedUrunStokYazisi.equalsIgnoreCase(actualUrunYazisi)) {
            System.out.println("Urun Stokta Mevcut, stok testi PASSED");
        }











    }

}
