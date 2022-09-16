package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(css = "div.search_results.movie div.results>div:nth-child(1) h2")
    private WebElement firstMovieResultTitle;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstMovieResult(){
        return firstMovieResultTitle.getText();
    }

}
