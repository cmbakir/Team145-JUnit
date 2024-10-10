package Cem_Tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class akakce2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");

        String expectedTitle= "YouTube";
        String actualTitle=driver.getTitle();
        Thread.sleep(3);

        Assertions.assertEquals(expectedTitle,actualTitle);
        System.out.println(actualTitle);

        driver.quit();


    }
}
