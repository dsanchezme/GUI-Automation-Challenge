package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TopRatedPage extends BasePage{

    @FindBy(css = "div.name[data-callback='filterCallback()']")
    private WebElement filterDropdown;
    @FindBy(css = "#with_genres a")
    private List<WebElement> allGenreItems;
    @FindBy(css = "div.apply.full a")
    private WebElement applyFilterButton;
    @FindBy(css = "#page_1>div")
    private List<WebElement> allFilterResults;

    public TopRatedPage(WebDriver driver) {
        super(driver);
    }

    public void filterByGenre(String genre){
        filterDropdown.click();
        for (WebElement item : allGenreItems){
            if (item.getText().equalsIgnoreCase(genre)){
                item.click();
                break;
            };
        }
        applyFilterButton.click();
    }

    public MoviePage selectAnyFilterResult(){
        Random random = new Random();
        int randomSelection = random.nextInt(allFilterResults.size());
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.stalenessOf(allFilterResults.get(randomSelection)));
        explicitWait.until(ExpectedConditions.elementToBeClickable(allFilterResults.get(randomSelection))).click();
        return new MoviePage(driver);
    }
}
