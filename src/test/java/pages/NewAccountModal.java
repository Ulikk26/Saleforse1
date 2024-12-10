package pages;

import DTO_models.Account;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.ComboBox;
import wrappers.Input;
import wrappers.Picklist;

@Log4j2
public class NewAccountModal extends BasePage {

    private final String BUTTON = "//button[text() = '%s']";
    private final By BUTTON_SAVE = By.xpath("//button[text() = '%Save']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAVE));
        return this;
    }

    @Override
    public NewAccountModal open() {
        return this;
    }

    @Builder
    @Step("Создание нового акаунта с валидными данными ")
    public NewAccountModal createAccount(Account account) {
        log.info("Editing the account");
        if (account.getAccountName() != null) {
            new Input(driver, "Account Name").write(account.getAccountName());
        }
        if (account.getAccountNumber() != null) {
            new Input(driver, "Account Number").write(account.getAccountNumber());
        }
        if (account.getPhone() != null) {
            new Input(driver, "Phone").write(account.getPhone());
        }
        if (account.getFax() != null) {
            new Input(driver, "Fax").write(account.getFax());
        }
        if (account.getAccountSite() != null) {
            new Input(driver, "Account Site").write(account.getAccountSite());
        }
        if (account.getRating() != null) {
            new Picklist(driver, "Rating").select(account.getRating());
        }
        if (account.getType() != null) {
            new Picklist(driver, "Type").select(account.getType());
        }
        if (account.getIndustry() != null) {
            new Picklist(driver, "Industry").select(account.getIndustry());
        }
        if (account.getAnnualRevenue() != null) {
            new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        }
        if (account.getWebsite() != null) {
            new Input(driver, "Website").write(account.getWebsite());
        }
        if (account.getTickerSymbol() != null) {
            new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        }
        if (account.getOwnership() != null) {
            new Picklist(driver, "Ownership").select(account.getOwnership());
        }
        if (account.getEmployees() != null) {
            new Input(driver, "Employees").write(account.getEmployees());
        }
        if (account.getParentAccount() != null) {
            new ComboBox(driver, "Parent Account").select(account.getParentAccount());
        }
        return this;
    }

    @Step("Нажать на кнопку {buttonName} ")
    public AccountsPage clickButton(String buttonName) {
        log.info("Clicking button '{}'", buttonName);
        By button = By.xpath(String.format(BUTTON, buttonName));
        driver.findElement(button).click();
        return new AccountsPage(driver);
    }
}
