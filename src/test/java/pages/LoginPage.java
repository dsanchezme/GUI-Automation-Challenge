package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login_button")
    private WebElement loginButton;
    @FindBy(css = "div.error_status h2")
    private WebElement errorMessageTitle;

    @FindBy(css = "div.error_status div.content ul li")
    private List<WebElement> errorMessageContentItems;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        logger.info("User login process...");
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        logger.debug("Entering username");
        usernameInput.sendKeys(username);
        logger.debug("Entering password");
        passwordInput.sendKeys(password);
        logger.debug("Validating credentials...");
        explicitWait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getLoginErrorMessageTitleClass(){
        return errorMessageTitle.getAttribute("class");
    }

    public int getLoginErrorMessageContentItems(){
        return errorMessageContentItems.size();
    }
}
