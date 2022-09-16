package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    private By usernameText = By.cssSelector("div.content_wrapper.flex a");
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUsernameLoggedIn(){
        return driver.findElement(usernameText).getText();
    }
}
