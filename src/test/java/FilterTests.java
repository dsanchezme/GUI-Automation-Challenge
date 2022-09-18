import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MoviePage;
import pages.TopRatedPage;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class FilterTests extends Hooks{

    @Test
    public void filterByActionGenre(){
        MainPage mainPage = new MainPage(driver);
        TopRatedPage topRatedPage = mainPage.goToTopRated();
        String genreToFilter = "action";
        topRatedPage.filterByGenre(genreToFilter);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MoviePage moviePage = topRatedPage.selectAnyFilterResult();
        Assert.assertTrue(moviePage.getMovieGenresList().contains(genreToFilter.toLowerCase()));
    }

    @Test
    public void ascendingDatesAfterSort(){
        MainPage mainPage = new MainPage(driver);
        TopRatedPage topRatedPage = mainPage.goToTopRated();
        topRatedPage.sortByDateAscending();
        int numberOfDates = 4;
        List<Date> dateResults = topRatedPage.getNDatesFromSortResult(numberOfDates);
        Boolean areDatesAscending = true;
        for (int i=0; i < numberOfDates-1; i++){
            areDatesAscending = areDatesAscending && dateResults.get(i).before(dateResults.get(i+1));
        }
        Assert.assertTrue(areDatesAscending);
    }
}
