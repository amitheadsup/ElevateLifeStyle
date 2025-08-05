package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        System.out.println("Launching browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.getExplicitWait()));
        driver.get(config.getBaseUrl());


    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            System.out.println("Closing browser...");
//            driver.quit();
//        }
//    }
public void waitForPage() {
    try {
        Thread.sleep(800);  // Or use explicit wait logic
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}
