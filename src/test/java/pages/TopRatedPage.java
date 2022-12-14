package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class TopRatedPage extends BasePage{

    @FindBy(css = "div.name[data-callback='filterCallback()']")
    private WebElement filterDropdown;
    @FindBy(css = "#with_genres a")
    private List<WebElement> allGenreItems;
    @FindBy(css = "div.apply.small a")
    private WebElement applyFilterButtonSmall;
    @FindBy(css = "div.apply.full a")
    private WebElement applyFilterButtonFull;
    @FindBy(css = "#page_1>div")
    private List<WebElement> allFilterResults;
    @FindBy(css = ".k-widget.k-dropdown.kendo_dropdown.full_width.font_size_1")
    private WebElement sortDropdown;
    @FindBy(css = "#sort_by_listbox>li:nth-child(6)")
    private WebElement sortByDateAscendingOption;
    @FindBy(css = ".card.style_1 p")
    private List<WebElement> allDatesSortResults;

    public TopRatedPage(WebDriver driver) {
        super(driver);
    }

    public void filterByGenre(String genre){
        logger.debug("Filtering movies by genre");
        filterDropdown.click();
        for (WebElement item : allGenreItems){
            if (item.getText().equalsIgnoreCase(genre)){
                item.click();
                break;
            };
        }
        handleApplyFilterClick();
    }

    public MoviePage selectAnyFilterResult(){
        logger.debug("Selecting any result after applying filter");
        Random random = new Random();
        int randomSelection = random.nextInt(allFilterResults.size());
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.stalenessOf(allFilterResults.get(randomSelection)));
        explicitWait.until(ExpectedConditions.elementToBeClickable(allFilterResults.get(randomSelection))).click();
        return new MoviePage(driver);
    }

    public void sortByDateAscending(){
        logger.debug("Sorting movies by date of release in ascending order");
        sortDropdown.click();
        sortByDateAscendingOption.click();
        handleApplyFilterClick();
    }

    public List<Date> getNDatesFromSortResult(int n){
        logger.debug("Getting dates from results after sorting process");
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.stalenessOf(allDatesSortResults.get(0)));
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        List<Date> selectedDates = new ArrayList<>();
        logger.debug("Parsing dates as text to Date objects");
        for (String textDate : allDatesSortResults.subList(0,n).stream().map(WebElement::getText).collect(Collectors.toList())){
            try {
                selectedDates.add(dateFormatter.parse(textDate));
            }catch (ParseException e){
                logger.warn("Unable to parse '" + textDate + "' to date");
            }
        }
        return selectedDates;
    }

    private void handleApplyFilterClick(){
        try{
            applyFilterButtonSmall.click();
        }catch (Exception e){
            applyFilterButtonFull.click();
        }
    }
}
