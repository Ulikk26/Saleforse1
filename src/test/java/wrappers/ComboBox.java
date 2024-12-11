package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class ComboBox {

    WebDriver driver;
    String label;
    String lookupPattern = "//label[text()='%s']//ancestor::lightning-lookup";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ComboBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.info("Selecting '{}' inside picklist",option,label);
        driver.findElement(By.xpath(String.format(lookupPattern + "//input", label)))
                .click();
        driver.findElement(By.xpath(String.format(lookupPattern + "//input", label))).sendKeys(option);
        driver.findElement(By.xpath(String.format(lookupPattern + "//lightning-base-combobox//strong[text()='%s']",
                label, option))).click();
    }
}
