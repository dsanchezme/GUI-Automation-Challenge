package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage{

    @FindBy(css = "div.search_results.movie div.results>div:nth-child(1) h2")
    private WebElement firstMovieResultTitle;
    @FindBy(css = "div.search_results.movie div.results>div:nth-child(1) a")
    private WebElement firstMovieResultLink;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstMovieResult(){
        logger.debug("Getting title for first movie result after search");
        return firstMovieResultTitle.getText();
    }

    public MoviePage goToFirstMovieResult(){
        logger.debug("Going to the page of the first movie result after search");
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(firstMovieResultLink)).click();
        return new MoviePage(driver);
    }

}
