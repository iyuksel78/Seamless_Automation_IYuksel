package seamless.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seamless.pages.HomePage;
import seamless.pages.LoginPage;
import seamless.utilities.ConfigurationReader;
import seamless.utilities.Driver;


public class Logout_StepDefinitions {

    HomePage home = new HomePage();
    LoginPage login = new LoginPage();

    final static Logger logger = LoggerFactory.getLogger(HomePage.class);


    @Given("the user is logged successfully")
    public void the_user_is_logged_successfully() {
        login.url(ConfigurationReader.getProperty("seamlessURL"));
        logger.info("user is on url");

        login.login(ConfigurationReader.getProperty("seamlessUserName"),
                ConfigurationReader.getProperty("seamlessPassWord"));
        logger.info("valid credentials entered");

        login.clickLoginButton();
        logger.info("loginButton is clicked");


    }

    @When("user clicks on avatar image")
    public void user_clicks_the_avatar_image() {
        home.clickAvatarImage();

    }

    @When("user clicks on Log out button from dropdown menu")
    public void user_clicks_on_log_out_button_from_dropdown_menu() {
        home.clickLogoutButton();

    }

    @Then("user  goes back to the login page")
    public void user_goes_back_to_the_login_page() {
        Assert.assertTrue(home.isLoginPageDisplayed());

    }

    //Second Scenario

    @When("user successfully logged out")
    public void user_successfully_logged_out() {
        home.logout();
        Assert.assertTrue(home.isLoginPageDisplayed());
        logger.info("login page is displayed");
    }

    @When("user click on step back button")
    public void user_click_on_step_back_button() {
        Driver.getDriver().navigate().back();
        logger.info("navigated back to home page");

    }

    @Then("user can not go to home page")
    public void user_can_not_go_to_home_page() {
        Assert.assertTrue(home.isLoginPageDisplayed());
        logger.info("login page is displayed");
    }


}
