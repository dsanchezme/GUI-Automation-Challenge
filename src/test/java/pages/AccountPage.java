package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(css = "div.content_wrapper.flex a")
    private WebElement usernameText;
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUsernameLoggedIn(){
        logger.debug("Getting username displayed in page account after login.");
        return usernameText.getText();
    }
}
