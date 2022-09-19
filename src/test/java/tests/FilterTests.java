package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MoviePage;
import pages.TopRatedPage;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class FilterTests extends Hooks{

    @Test(description = "Verify Movie Genre Filter")
    @Description("Verify filter by genre for action movies")
    public void filterByActionGenre(){
        logger.info("Testing filtering process by genre for action movies");
        MainPage mainPage = new MainPage(driver);
        TopRatedPage topRatedPage = mainPage.goToTopRated();
        String genreToFilter = "action";
        topRatedPage.filterByGenre(genreToFilter);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MoviePage moviePage = topRatedPage.selectAnyFilterResult();
        Assert.assertTrue(moviePage.getMovieGenresList().contains(genreToFilter.toLowerCase()));
    }

    @Test(description = "Sort by Dates on Ascending Order")
    @Description("Sort movies by date of release on ascending order")
    public void ascendingDatesAfterSort(){
        logger.info("Testing sorting process by date of release in ascending order");
        MainPage mainPage = new MainPage(driver);
        TopRatedPage topRatedPage = mainPage.goToTopRated();
        topRatedPage.sortByDateAscending();
        int numberOfDates = 4;
        List<Date> dateResults = topRatedPage.getNDatesFromSortResult(numberOfDates);
        boolean areDatesAscending = true;
        for (int i=0; i < numberOfDates-1; i++){
            areDatesAscending = areDatesAscending && dateResults.get(i).before(dateResults.get(i+1));
        }
        Assert.assertTrue(areDatesAscending);
    }
}
