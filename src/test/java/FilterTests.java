import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MoviePage;
import pages.TopRatedPage;

import java.time.Duration;

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
}
