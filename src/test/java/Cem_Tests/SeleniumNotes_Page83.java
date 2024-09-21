package Cem_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class SeleniumNotes_Page83 extends TestBase_Each {

    //1. http://zero.webappsecurity.com
    // sayfasina gidin
    //2. Signin buttonuna tiklayin
    //3. Login alanine “username” yazdirin
    //4. Password alanina “password” yazdirin
    //5. Sign in buttonuna tiklayin
    //6. Back tusu ile sayfaya donun
    //7. Online Banking menusunden Pay Bills sayfasina gidin
    //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    //9. tarih kismina “2023-09-10” yazdirin
    //10. Pay buttonuna tiklayin
    //11. “The payment was successfully submitted.” mesajinin ciktigini test edin


    @Test
    public void test01(){
       // 1. http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='button']"))
                .click();
       //  3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

       //4. Password alanina “password” yazdirin

        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin

        driver.findElement(By.xpath("//*[@name='submit']")).click();

        ReusableMethods.bekle(2);

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin

        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin

        WebElement amountKutusu = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amountKutusu.sendKeys("4500");

        //9. tarih kismina “2023-09-10” yazdirin

        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2023-09-10");

        //10. Pay buttonuna tiklayin

        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        String expectedOdemeBasarili = "The payment was successfully submitted.";

        String actualOdemeBasarili = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();

        Assertions.assertEquals(expectedOdemeBasarili,actualOdemeBasarili);











    }
}
