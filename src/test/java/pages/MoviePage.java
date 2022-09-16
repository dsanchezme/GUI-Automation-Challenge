package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MoviePage extends BasePage{

    @FindBy(css = "span.genres a")
    private List<WebElement> allMovieGenres;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getMovieGenresList(){
        return allMovieGenres.stream().map(WebElement::getText).map(String::toLowerCase).collect(Collectors.toList());
    }
}
