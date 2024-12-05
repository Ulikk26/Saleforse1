package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "Login")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public LoginPageFactory isPageOpened() {
        return this;
    }

    @Override
    public LoginPageFactory open() {
        return this;
    }

    public void login(String userName, String password) {
        userNameField.sendKeys("userName");
        passwordField.sendKeys("password");
        loginButton.click();
    }
}
