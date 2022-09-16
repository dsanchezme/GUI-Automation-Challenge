package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MoviePage extends BasePage{

    @FindBy(css = "span.genres a")
    private List<WebElement> allMovieGenres;
    @FindBy(css = "div#cast_scroller li:nth-child(1)>a")
    private WebElement firstActorCard;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getMovieGenresList(){
        return allMovieGenres.stream().map(WebElement::getText).map(String::toLowerCase).collect(Collectors.toList());
    }

    public ActorPage goToFirstActorPage(){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(firstActorCard)).click();
        return new ActorPage(driver);
    }
}
