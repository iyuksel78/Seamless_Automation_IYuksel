package seamless.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seamless.utilities.ConfigurationReader;
import seamless.utilities.Driver;

public class HomePage {

LoginPage login = new LoginPage();
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@src='/index.php/avatar/Employee190/32?v=2']")
    public WebElement avatarImage;

    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    public WebElement logoutButton;

    @FindBy(xpath = "//h2[contains(.,'Good afternoon, Yuksel')]")
    public WebElement dashboardMessage;



    public void clickAvatarImage() {
        avatarImage.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isLoginPageDisplayed() {
        return Driver.getDriver().getCurrentUrl().contains("https://qa.seamlessly.net/index" +
                ".php/login");
    }

    public boolean isHomePageDisplayed() {
          return      dashboardMessage.isDisplayed();
    }

    public void logout(){
        avatarImage.click();
        logoutButton.click();
    }
}
