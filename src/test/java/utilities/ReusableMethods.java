package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    // Webelement'lerden olusan listeyi,
    // String'lerden olusan listeye ceviren bir method olusturalim

    public static List<String> stringListeyeCevir(List<WebElement> elementListesi){

        List<String> stringListesi = new ArrayList<>();

        for (WebElement eachElement : elementListesi) {

            stringListesi.add(eachElement.getText());
        }

        return stringListesi;
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep( saniye*1000);
        } catch (InterruptedException e) {

        }

    }

    public static void switchToWindowByTitle(WebDriver driver , String istenenSayfaTitle){
        Set<String> acikOlanWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWhd : acikOlanWindowlarinWHDSeti){

            driver.switchTo().window(eachWhd);
            ReusableMethods.bekle(1);

            if (driver.getTitle().equals(istenenSayfaTitle)){
                break;
            }

        }
    }

    public static void switchToWindowByUrl(WebDriver driver , String istenenSayfaUrl){
        Set<String> acikOlanWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWhd : acikOlanWindowlarinWHDSeti){

            driver.switchTo().window(eachWhd);
            ReusableMethods.bekle(1);

            if (driver.getCurrentUrl().equals(istenenSayfaUrl)){
                break;
            }

        }
    }

    public static void getScreenshotTumSayfa(WebDriver driver,String ssIsmi){
        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/"+ssIsmi+".png";

        // 2. TakesScreenshot objesi olusturalim

        // TakesScreenshot tss = new TakesScreenshot();
        // 'TakesScreenshot' is abstract; cannot be instantiated

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 3.adim screenshot'i kaydedecegimiz File'i olusturalim

        File tumsayfaSS = new File(dosyaYolu);

        // 4.adim screenshot'i alip gecici dosua olarak kaydedin

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 5.adim gecici resmi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,tumsayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void getScreenshotTumSayfa(WebDriver driver){

        // 240924202034
        LocalDateTime ldt = LocalDateTime.now(); // 2024-09-24T20-23-24-123432

        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(istenenFormat);

        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/TumSayfaSS"+tarihEtiketi+".png";

        // 2. TakesScreenshot objesi olusturalim

        // TakesScreenshot tss = new TakesScreenshot();
        // 'TakesScreenshot' is abstract; cannot be instantiated

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 3.adim screenshot'i kaydedecegimiz File'i olusturalim

        File tumsayfaSS = new File(dosyaYolu);

        // 4.adim screenshot'i alip gecici dosua olarak kaydedin

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 5.adim gecici resmi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,tumsayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getScreenshotTumSayfaTarihli(WebDriver driver,String ssIsmi){

        // cem olusturdu 240924202034
        LocalDateTime ldt = LocalDateTime.now(); // 2024-09-24T20-23-24-123432

        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yy_MM_dd_HHmmss");
        String tarihEtiketi = ldt.format(istenenFormat);

        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/TumSayfaSS_"+ssIsmi+tarihEtiketi+".png";

        // 2. TakesScreenshot objesi olusturalim

        // TakesScreenshot tss = new TakesScreenshot();
        // 'TakesScreenshot' is abstract; cannot be instantiated

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 3.adim screenshot'i kaydedecegimiz File'i olusturalim

        File tumsayfaSS = new File(dosyaYolu);

        // 4.adim screenshot'i alip gecici dosua olarak kaydedin

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 5.adim gecici resmi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,tumsayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getScreenshotWebElement(WebDriver driver, WebElement webElement){

        LocalDateTime ldt = LocalDateTime.now(); // 2024-09-24T20-23-24-123432

        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(istenenFormat);

        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/WebElementSS"+tarihEtiketi+".png";

        // 2- kullanacagimiz WebElementi locate edip, WebElement olarak kaydedin
        //    parametre olarak gonderilen webElement'in ss alinacak

        // 3- kaydedecegimiz file'i olusturun

        File webElementSS = new File(dosyaYolu);

        // 4- webElement uzerinden screenshot'i alip, gecici dosya olarak kaydedin

        File geciciDosya = webElement.getScreenshotAs(OutputType.FILE);

        // 5- gecici dosyayi asil dosyaya kopyala

        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}