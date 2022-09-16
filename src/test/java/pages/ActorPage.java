package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ActorPage extends BasePage{

    @FindBy(css = "div.credits_list>table:nth-child(2) bdi")
    private List<WebElement> timelineMovieTitles;

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTimelineMovieTitles(){
        return timelineMovieTitles.stream().map(WebElement::getText).map(String::toLowerCase).collect(Collectors.toList());
    }
}
