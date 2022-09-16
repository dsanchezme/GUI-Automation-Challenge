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
    @FindBy(id = "inner_search_v4")
    private WebElement inputSearchMovie;
    @FindBy(css = "#inner_search_form>input[type='submit']")
    private WebElement buttonSearchMovie;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(goToLoginButton)).click();
        return new LoginPage(driver);
    }

    public SearchPage searchMovie(String movieName){
        inputSearchMovie.sendKeys(movieName);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(buttonSearchMovie)).click();
        return new SearchPage(driver);
    }
}
