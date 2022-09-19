package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActorPage;
import pages.MainPage;
import pages.MoviePage;
import pages.SearchPage;

public class TimelineTests extends Hooks{

    @Test(description = "Validate Acting Timeline")
    @Description("Validating acting timeline")
    public void movieInActingTimeline(){
        logger.info("Testing presence of movie title in an actor's timeline");
        MainPage mainPage = new MainPage(driver);
        String movieName = "Doctor Strange in the Multiverse of Madness";
        SearchPage searchPage = mainPage.searchMovie(movieName);
        MoviePage moviePage = searchPage.goToFirstMovieResult();
        ActorPage actorPage = moviePage.goToFirstActorPage();
        Assert.assertTrue(actorPage.getTimelineMovieTitles().contains(movieName.toLowerCase()));
    }
}
