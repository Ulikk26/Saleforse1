package tests.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComboBox {

    WebDriver driver;
    String label;
    String lookupPattern = "//label[text()='%s']//ancestor::lightning-lookup";

    public ComboBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(lookupPattern + "//input", label)))
                .click();
        driver.findElement(By.xpath(String.format(lookupPattern + "//lightning-base-combobox//span[text()='%s']",
                label, option))).click();
    }
}
