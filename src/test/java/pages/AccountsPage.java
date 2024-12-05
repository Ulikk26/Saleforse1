package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    private final String BUTTON = "//div[@title='%s']";
    private final String ACTION_BUTTON = "(//a[contains(@title, '%s')])[1]//ancestor::tr//span[text()='Show Actions']//ancestor::a";
    private final String ITEM_FROM_ACTION = "//a[@role='menuitem' and @title='%s']";
    private final String ACCOUNT_MANE = "(//a[contains(@title, '%s')])[1]";
   private final By SEARCH_FIELD=By.xpath("//div[@type='search']//input");


    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
        return this;
    }

    @Step("Открытие страницы Accounts")
    public AccountsPage open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        return this;
    }

    @Step("Нажать на кнопку {buttonName} ")
    public NewAccountModal clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON, buttonName));
        driver.findElement(button).click();
        return new NewAccountModal(driver);
    }

    @Step("Нажатие кнопки {action} через Action Button у первого элемента с именем {name}")
    public EditWindowPage clickActionButton(String action, String name) {
        WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(ACTION_BUTTON, name))));
        actionButton.click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(ITEM_FROM_ACTION, action))));
        element.click();
        return new EditWindowPage(driver);
    }

    public AccountsPage inputSearchField (String name){
        driver.findElement(SEARCH_FIELD).click();
        driver.findElement(SEARCH_FIELD).sendKeys(name);
        driver.findElement(SEARCH_FIELD).sendKeys(Keys.ENTER);
        return this;
    }
}
