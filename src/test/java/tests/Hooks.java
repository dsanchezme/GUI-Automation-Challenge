package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Hooks {
    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger("tests-logger");

    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.debug("Browser opened");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        logger.debug("Browser closed");
    }
}
