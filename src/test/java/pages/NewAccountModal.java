package pages;

import DTO_models.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.wrappers.ComboBox;
import tests.wrappers.Input;
import tests.wrappers.Picklist;

public class NewAccountModal extends BasePage {

    private final String BUTTON = "//button[text() = '%s']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Step("Создание нового акаунта с валидными данными ")
    public NewAccountModal createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Account Number").write(account.getAccountNumber());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Account Site").write(account.getAccountSite());
        new Picklist(driver, "Rating").select(account.getRating());
        new Picklist(driver, "Type").select(account.getType());
        new Picklist(driver, "Industry").select(account.getIndustry());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        new Picklist(driver, "Ownership").select(account.getOwnership());
        new Input(driver, "Employees").write(account.getEmployees());
        new ComboBox(driver,"Parent Account").select(account.getParentAccount());
        return this;
    }

    @Step("Нажать на кнопку {buttonName} ")
    public AccountsPage clickActionButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON, buttonName));
        driver.findElement(button).click();
        return new AccountsPage(driver);
    }
}
