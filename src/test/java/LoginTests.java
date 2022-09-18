import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends Hooks{

    @Test
    public void validUserLogin(){
        logger.info("Testing login process with valid credentials");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.goToLoginPage();
        String username = System.getenv("TMDB_VALID_USERNAME");
        String password = System.getenv("TMDB_VALID_PASSWORD");
        loginPage.login(username, password);
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getUsernameLoggedIn(), username, "The username entered does not match with the username displayed");
        logger.debug("Login process succeed!");
    }

    @Test
    public void redBoxInvalidUserLogin(){
        logger.info("Testing appearance of displayed box when login when invalid credentials");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.goToLoginPage();
        String username = "Invalid username";
        String password = "Invalid password";
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getLoginErrorMessageTitleClass().contains("red"), "The error message box is not red");
    }

    @Test
    public void twoItemsInvalidUserLogin(){
        logger.info("Testing presence of 2 messages displayed when login when invalid credentials");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.goToLoginPage();
        String username = "Invalid username";
        String password = "Invalid password";
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getLoginErrorMessageContentItems(), 2, "The number of messages displayed is not equal to 2");
    }
}
