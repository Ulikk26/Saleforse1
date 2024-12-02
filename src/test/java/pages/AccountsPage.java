package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    private final By BUTTON_NEW = By.xpath("//div[@title = 'New']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Accounts")
    public void openAccountsPage() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
    }

    @Step("Нажатие на кнопку New на странице Accounts")
    public void clickButtonNew() {
        driver.findElement(BUTTON_NEW).click();
    }
}
