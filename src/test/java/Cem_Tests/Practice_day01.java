package Cem_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice_day01 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");

        String exceptedTitle = "Youtube";
        String actualTitle = driver.getTitle();

        if(exceptedTitle.equals(actualTitle)) {
            System.out.println("Test PASSED");
            System.out.println(actualTitle);
        } else {
            System.out.println( "Test FAILED");
        }

        driver.quit();


    }
}
