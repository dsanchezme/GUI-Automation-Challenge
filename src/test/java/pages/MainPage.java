package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage{

    @FindBy(css = "div.flex a[href='/login']")
    private WebElement goToLoginButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(goToLoginButton)).click();
        return new LoginPage(driver);
    }
}
