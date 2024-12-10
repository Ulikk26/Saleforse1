package pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public abstract BasePage isPageOpened();

    public abstract BasePage open();

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
