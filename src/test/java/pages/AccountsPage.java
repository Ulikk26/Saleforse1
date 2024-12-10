package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AccountsPage extends BasePage {

    private final String BUTTON = "//div[@title='%s']";
    private final String ACTION_BUTTON = "(//a[contains(@title, '%s')])[1]//ancestor::tr//span[text()='Show Actions']//ancestor::a";
    private final String ITEM_FROM_ACTION = "//a[@role='menuitem' and @title='%s']";
    private final By SEARCH_FIELD = By.xpath("//div[@type='search']//input");
    private final By SUCCESS_MESSAGE_CREATE = By.xpath("//span[contains(@class, 'toastMessage') and contains(@class, 'forceActionsText') and contains(., 'was created')]");
    private final By SUCCESS_MESSAGE_NAME = By.xpath("//span[@data-aura-class='forceActionsText']//a/div");
    private final By EDIT_SUCCESS_MESSAGE = By.xpath("//span[contains(@class, 'toastMessage') and contains(@class, 'forceActionsText') and contains(., 'was saved')]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD));
        return this;
    }

    @Step("Открытие страницы Accounts")
    public AccountsPage open() {
        log.info("Opening the accounts page");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        return this;
    }

    @Step("Нажать на кнопку {buttonName} ")
    public NewAccountModal clickButton(String buttonName) {
        log.info("Clicking button '{}'", buttonName);
        By button = By.xpath(String.format(BUTTON, buttonName));
        driver.findElement(button).click();
        return new NewAccountModal(driver);
    }

    @Step("Нажатие кнопки {action} через Action Button у первого элемента с именем {name}")
    public EditModal clickActionButton(String action, String name) {
        log.info("Clicking button '{}' into string with name {}", action, name);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(ACTION_BUTTON, name))));
        By actionButton = By.xpath(String.format(ACTION_BUTTON, name));
        driver.findElement(actionButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(ITEM_FROM_ACTION, action))));
        By element = By.xpath(String.format(ITEM_FROM_ACTION, action));
        driver.findElement(element).click();
        return new EditModal(driver);
    }

    @Step("Ввод {name} в строку поиска и поиск по этому элементу")
    public AccountsPage inputSearchField (String name){
        log.info("Filter accounts list by element {}", name);
        driver.findElement(SEARCH_FIELD).click();
        driver.findElement(SEARCH_FIELD).sendKeys(name);
        driver.findElement(SEARCH_FIELD).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Проверка названия созданного аккаунта")
    public String checkNameCreatedAccount() {
        log.info("Check created name {}");
        return driver.findElement(SUCCESS_MESSAGE_NAME).getText();
    }

    @Step("Проверка сообщения об успешном создании аккаунта")
    public WebElement checkCreateSuccessMassage() {
        log.info("Check success massage about creating account");
        return driver.findElement(SUCCESS_MESSAGE_CREATE);
    }

    @Step("Проверка сообщения об успешном сохранении изменений  аккаунта")
    public WebElement checkSaveSuccessMassage() {
        log.info("Check success massage about editing account");
        return driver.findElement(EDIT_SUCCESS_MESSAGE);
    }
}
