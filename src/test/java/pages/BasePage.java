package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public abstract class BasePage {

    private final By SUCCESS_MESSAGE = By.cssSelector("[data-aura-class=forceActionsText]");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public abstract BasePage isPageOpened();

    public abstract BasePage open();

    @Step("Сообщение об успешном создании аккаунта")
    public BasePage checkSuccessMassage() {
        WebElement message = driver.findElement(SUCCESS_MESSAGE);
        Assert.assertTrue(message.isDisplayed(), "Сообщение об успешном создании аккаунта не отображается");
        return this;
    }

    // ждет загрузки всей страницы
    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Objects.requireNonNull(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .toString().equals("complete");
            }
        };
    }

    // нажатие на элемент, который чем-то перекрыт
    public void clickJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click();", element);
    }

    //скролл по вертикали и горизонтали
    public void scrollJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 900)");
    }

    //скорлл до определенного элемента
    public void scrollJSElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollIntoView(true);", element);
    }

    //
    public void scroll() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("")));
    }
}
