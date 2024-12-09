package pages;

import DTO_models.Account;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.ComboBox;
import wrappers.Input;
import wrappers.Picklist;

@Log4j2
public class EditModal extends BasePage {

    private final By EDIT_MODAL_WINDOW = By.xpath("//records-modal-lwc-detail-panel-wrapper");
    private final String BUTTON = "//button[text() = '%s']";

    public EditModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public EditModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Save']")));
        return this;
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Step("Проверка отображения модального окна редактирования данных")
    public EditModal editWindowIsDisplayed() {
        log.info("EditModal is opened");
        WebElement editWindow = wait.until(ExpectedConditions.elementToBeClickable(EDIT_MODAL_WINDOW));
        Assert.assertTrue(editWindow.isDisplayed(), "модалка редактирования данных не отображается ");
        return new EditModal(driver);
    }

    @Builder
    @Step("Редактирование аккаунта")
    public EditModal editAccount(Account account) {
        log.info("Editing account");
        if (account.getAccountName() != null) {
            new Input(driver, "Account Name").clearInput("Account Name");
            new Input(driver, "Account Name").write(account.getAccountName());
        }
        if (account.getAccountNumber() != null) {
            new Input(driver, "Account Number").clearInput("Account Number");
            new Input(driver, "Account Number").write(account.getAccountNumber());
        }
        if (account.getPhone() != null) {
            new Input(driver, "Phone").clearInput("Phone");
            new Input(driver, "Phone").write(account.getPhone());
        }
        if (account.getFax() != null) {
            new Input(driver, "Fax").clearInput("Fax");
            new Input(driver, "Fax").write(account.getFax());
        }
        if (account.getAccountSite() != null) {
            new Input(driver, "Account Site").clearInput("Account Site");
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
            new Input(driver, "Annual Revenue").clearInput("Annual Revenue");
            new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        }
        if (account.getWebsite() != null) {
            new Input(driver, "Website").clearInput("Website");
            new Input(driver, "Website").write(account.getWebsite());
        }
        if (account.getTickerSymbol() != null) {
            new Input(driver, "Ticker Symbol").clearInput("Ticker Symbol");
            new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        }
        if (account.getOwnership() != null) {
            new Picklist(driver, "Ownership").select(account.getOwnership());
        }
        if (account.getEmployees() != null) {
            new Input(driver, "Employees").clearInput("Employees");
            new Input(driver, "Employees").write(account.getEmployees());
        }
        if (account.getParentAccount() != null) {
            new ComboBox(driver, "Parent Account").select(account.getParentAccount());
        }
        return this;
    }

    @Step("Нажать на кнопку {buttonName} ")
    public AccountsPage clickActionButton(String buttonName) {
        log.info("Clicking button {}", buttonName);
        By button = By.xpath(String.format(BUTTON, buttonName));
        driver.findElement(button).click();
        return new AccountsPage(driver);
    }
}
