import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;

public class SearchTests extends Hooks{

    @Test
    public void movieSearch(){
        MainPage mainPage = new MainPage(driver);
        String movieToSearch = "Fight Club";
        SearchPage searchPage = mainPage.searchMovie(movieToSearch);
        Assert.assertTrue(searchPage.getFirstMovieResult().contains(movieToSearch));
    }
}
