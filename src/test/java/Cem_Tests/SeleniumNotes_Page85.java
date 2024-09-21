package Cem_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class SeleniumNotes_Page85 extends TestBase_Each {

            //1. “https://www.saucedemo.com” Adresine gidin
            //2. Username kutusuna “standard_user” yazdirin
            //3. Password kutusuna “secret_sauce” yazdirin
            //4. Login tusuna basin
            //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
            //6. Add to Cart butonuna basin
            //7. Alisveris sepetine tiklayin
            //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
            //9. Sayfayi kapatin

    @Test
    public void test01(){

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin

        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin

        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        String ilkUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();

        ReusableMethods.bekle(2);

        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();

        //6. Add to Cart butonuna basin
        ReusableMethods.bekle(2);

        driver.findElement(By.xpath("//*[@id='add-to-cart']")).click();

        //7. Alisveris sepetine tiklayin
        ReusableMethods.bekle(2);

        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        ReusableMethods.bekle(2);

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        WebElement urunAdet = driver.findElement(By.xpath("//*[text()='1']"));
        WebElement urunIsim = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));

        System.out.println(urunAdet.getText() + " adet, " + urunIsim.getText() + " , isimli urun sepete eklenmistir");

        Assertions.assertTrue(urunIsim.isDisplayed() && urunAdet.isDisplayed());

        //9. Sayfayi kapatin

        driver.quit();








    }



}
