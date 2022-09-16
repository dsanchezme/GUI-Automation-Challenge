import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActorPage;
import pages.MainPage;
import pages.MoviePage;
import pages.SearchPage;

public class TimelineTests extends Hooks{

    @Test
    public void movieInActingTimeline(){
        MainPage mainPage = new MainPage(driver);
        String movieName = "Doctor Strange in the Multiverse of Madness";
        SearchPage searchPage = mainPage.searchMovie(movieName);
        MoviePage moviePage = searchPage.goToFirstMovieResult();
        ActorPage actorPage = moviePage.goToFirstActorPage();
        Assert.assertTrue(actorPage.getTimelineMovieTitles().contains(movieName.toLowerCase()));
    }
}