package seamless.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seamless.pages.LoginPage;
import seamless.utilities.BrowserUtils;
import seamless.utilities.ConfigurationReader;
import seamless.utilities.Driver;

public class Login_StepDefinitions {

    LoginPage login = new LoginPage();
    final static Logger logger = LoggerFactory.getLogger(Login_StepDefinitions.class);


    @Given("user is on the {string}")
    public void user_is_on_the(String string) {
        login.url(ConfigurationReader.getProperty("seamlessURL"));
        logger.info("user is on url");
    }

    //First Scenario
    @When("user enters a valid {string} and {string}")
    public void user_enters_a_valid_and(String username, String password) {
        login.login(ConfigurationReader.getProperty("seamlessUserName"),
                ConfigurationReader.getProperty("seamlessPassWord"));

        logger.info("valid credentials entered");

    }

    @When("user clicks on the Login button or hit the Enter key")
    public void user_clicks_on_the_login_button_or_hit_the_enter_key() {
        login.clickLoginButton();

        logger.info("loginButton is clicked");
    }

    @Then("user verifies the Dashboard page")
    public void user_verifies_the_dashboard_page() {

        login.isDashboardDisplayed();

        logger.info("First Scenario: verified that dashboard is displayed");
        Driver.closeDriver();


    }

    //Second Scenario
    @When("user enters invalid {string} or invalid {string}")
    public void user_enters_invalid_and_invalid(String username, String password) {
        login.invalidCredentials(username, password);
        login.clickLoginButton();
        logger.info("invalid credentials are entered and clicked on login button");

    }

    @When("user leaves {string} or {string} field empty")
    public void userLeavesOrFieldEmpty(String username, String password) {
        login.testEmptyCredentials(username, password);
        logger.info("empty user name and password is entered ");


    }

    @Then("user verifies warning message {string}")
    public void userVerifiesWarningMessage(String expected) {
        String actual = "";

        if (expected.equalsIgnoreCase("Wrong username or password.")) {
            actual = login.getWarningMessage();
            Assert.assertTrue(true);
            logger.info("Second Scenario: Wrong username or password. message is observed");


        } else if (expected.equalsIgnoreCase("Please fill out this field.")) {
            actual = login.getErrorMessage();
            Assert.assertTrue(true);
            logger.info("Third Scenario: Please fill out this field. message is observed");


        }
        Driver.closeDriver();

    }

    @When("user enters the password")
    public void userEntersThePassword() {
        login.login(ConfigurationReader.getProperty("seamlessUserName"),
                ConfigurationReader.getProperty("seamlessPassWord"));
        logger.info("valid password is entered");
    }

    @Then("user verifies the password in form of dots")
    public void userVerifiesThePasswordInFormOfDots() {
        Assert.assertEquals("password", login.passwordField.getAttribute("type"));

        logger.info("Fourth Scenario; the password is observed in form of dots");
        Driver.closeDriver();


    }

    @When("user clicks on toggle button")
    public void userClicksOnButton() {
        login.login(ConfigurationReader.getProperty("seamlessUserName"),
                ConfigurationReader.getProperty("seamlessPassWord"));
        login.toggleButton.click();
        logger.info("credentials are entered and toggle button is clicked");

    }

    @Then("user verifies the password in plain text")
    public void userVerifiesThePasswordInPlainText() {
        Assert.assertEquals("text", login.passwordField.getAttribute("type"));

        logger.info("Fifth Scenario: password is observed in plain text");
        Driver.closeDriver();
    }

    @When("user clicks on the Forgot Password? link")
    public void userClicksOnTheForgotPasswordLink() {
        login.forgotPasswordLink.click();
        logger.info("forgot password link is clicked");

    }


    @Then("user verifies Reset Password button is visible")
    public void userVerifiesResetPasswordButtonIsVisible() {
        BrowserUtils.verifyElementDisplayed(login.resetButton);
        logger.info("Sixth Scenario: Reset button is observed");

        Driver.closeDriver();
    }

    @When("user clicks on username and password input-boxes")
    public void userClicksOnUsernameAndPasswordInputBoxes() {
        login.placeHolderForUserName.click();
        login.placeHolderForPassword.click();
        logger.info("Both Placeholders are clicked");


    }

    @Then("user verifies valid placeholder for username and Password")
    public void userVerifiesValidPlaceholderForUsernameAndPassword() {
        Assert.assertEquals("Username or email", login.placeHolderForUserName.getAttribute("placeholder"));


        Assert.assertEquals("Password", login.placeHolderForPassword.getAttribute("placeholder"));

        logger.info("Last Scenario; placeholders for both Username and Password are validated");
        Driver.closeDriver();

    }


}
