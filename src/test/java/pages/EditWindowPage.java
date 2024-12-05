package pages;

import DTO_models.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import tests.wrappers.Input;
import tests.wrappers.Picklist;

public class EditWindowPage extends BasePage {

    private final By EDIT_MODAL_WINDOW = By.xpath("//records-modal-lwc-detail-panel-wrapper");
    private final String BUTTON = "//button[text() = '%s']";

    public EditWindowPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EditWindowPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Save']")));
        return this;
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Step("Проверка отображения модального окна редактирования данных")
    public EditWindowPage editWindowIsDisplayed() {
        WebElement editWindow = wait.until(ExpectedConditions.elementToBeClickable(EDIT_MODAL_WINDOW));
        Assert.assertTrue(editWindow.isDisplayed(), "модалка редактирования данных не отображается ");
        return new EditWindowPage(driver);
    }

    @Step("Редактирование аккаунта")
    public EditWindowPage editAccount(Account account, String accountName, String rating) {
        account.setAccountName(accountName);
        account.setRating(rating);
        new Input(driver, "Account Name").clearInput("Account Name");
        new Input(driver, "Account Name").write(account.getAccountName());
        new Picklist(driver, "Rating").select(account.getRating());
        return this;
    }

    @Step("Нажать на кнопку {buttonName} ")
    public AccountsPage clickActionButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON, buttonName));
        driver.findElement(button).click();
        return new AccountsPage(driver);
    }
}
