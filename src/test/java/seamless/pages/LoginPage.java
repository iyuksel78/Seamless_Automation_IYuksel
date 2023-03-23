package seamless.pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seamless.utilities.BrowserUtils;
import seamless.utilities.ConfigurationReader;
import seamless.utilities.Driver;

public class LoginPage {
    Faker faker = new Faker();

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField2;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement toggleButton;

    @FindBy (xpath = "//a[@id='lost-password']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetButton;

    @FindBy(xpath = "//input[@placeholder='Username or email']")
    public WebElement placeHolderForUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement placeHolderForPassword;





    public void url(String url) {
        Driver.getDriver().get(url);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

    }

    public void invalidCredentials(String username, String password) {

        usernameField.clear();
        usernameField.sendKeys(faker.name().username());
        passwordField.clear();
        passwordField.sendKeys(faker.internet().password());

    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void isDashboardDisplayed() {
        BrowserUtils.verifyURLContains("dashboard");
    }

    public String getWarningMessage() {
        return warningMessage.getText();

    }

    public void testEmptyCredentials(String username, String password) {

        usernameField.sendKeys(ConfigurationReader.getProperty("seamlessUserName"));
        passwordField.sendKeys("");
        loginButton.click();

    }

    public String getErrorMessage() {
        return passwordField.getAttribute("validationMessage");

    }




}
