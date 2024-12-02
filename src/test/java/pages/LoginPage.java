package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USER_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public void openLoginPage() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning");
    }

    @Step("Вход в систему под логином {user} и паролем {password}")
    public void login(String user, String password){
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
