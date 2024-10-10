package Cem_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class AkakceTest extends TestBase_Each {


    //1) https://www.youtube.com adresine gidin
    //2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void titleTest01() throws InterruptedException {
        //1) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

        String expectedTitle= "YouTube";
        String actualTitle=driver.getTitle();
        Thread.sleep(3);

        Assertions.assertEquals(expectedTitle,actualTitle);
        System.out.println(actualTitle);

        driver.quit();



    }
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() throws InterruptedException {
        driver.get("https://www.youtube.com");
        WebElement youTubeLogo =driver.findElement(By.xpath("(//*[@id='logo'])[2]"));
        Assertions.assertTrue(youTubeLogo.isDisplayed());

        driver.quit();

    }

    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBoxTest(){
        driver.get("https://www.youtube.com");
        WebElement searchBox= driver.findElement(By.xpath("//*[@id='search-input']"));
        Assertions.assertTrue(searchBox.isEnabled());

    }

    @Test
    public void wrongTitle(){
        driver.get("https://www.youtube.com");
        String expectedTitle="youtube";
        String actualTitle = driver.getTitle();

        Assertions.assertNotEquals(expectedTitle,actualTitle);
        System.out.println(actualTitle);
    }

}
