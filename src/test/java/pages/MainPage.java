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
    @FindBy(css = "a.no_click.k-link[href='/movie']")
    private WebElement moviesHeaderItem;
    @FindBy(css = "a.k-link.k-menu-link[href='/movie/top-rated']")
    private WebElement moviesTopRatedItem;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.debug("Going to login page");
        explicitWait.until(ExpectedConditions.elementToBeClickable(goToLoginButton)).click();
        return new LoginPage(driver);
    }

    public SearchPage searchMovie(String movieName){
        logger.debug("Typing movie to search");
        inputSearchMovie.sendKeys(movieName);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.debug("Searching movie...");
        explicitWait.until(ExpectedConditions.elementToBeClickable(buttonSearchMovie)).click();
        return new SearchPage(driver);
    }

    public TopRatedPage goToTopRated(){
        logger.debug("Going to Top rated movies page");
        moviesHeaderItem.click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.elementToBeClickable(moviesTopRatedItem)).click();
        return new TopRatedPage(driver);
    }
}
