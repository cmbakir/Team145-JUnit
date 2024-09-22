package Cem_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class SeleniumNotes_Page101 extends TestBase_All {

    //1) https://www.youtube.com adresine gidin
    //2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void titleTest(){

        //1) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

        String expectedTitle ="YouTube";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
        System.out.println(actualTitle);

    }

    @Test
    public void imageTest(){
        driver.get("https://www.youtube.com");
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo'])[1]"));
        Assertions.assertTrue(logo.isDisplayed());

    }

//○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBoxTest(){
        driver.get("https://www.youtube.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search-input']"));

        Assertions.assertTrue(searchBox.isEnabled());

    }
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitle(){
        driver.get("https://www.youtube.com");
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        Assertions.assertNotEquals(expectedTitle,actualTitle);
    }
}
