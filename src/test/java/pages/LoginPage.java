package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    private final By USER_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        log.info("Checking LoginPage is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step("Открытие страницы логина")
    public LoginPage open() {
        log.info("Opening LoginPage");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning");
        return this;
    }

    @Step("Вход в систему под логином {user} и паролем {password}")
    public AccountsPage login(String user, String password) {
        log.info("Login with user {} and password {}", user, password);
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new AccountsPage(driver);
    }
}
