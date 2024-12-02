package tests.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Picklist {
    WebDriver driver;
    String label;
    String pickListPattern = "//label[text()='%s']//ancestor::lightning-picklist";

    public Picklist(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(pickListPattern + "//button", label)))
                .click();
        driver.findElement(By.xpath(String.format(pickListPattern + "//lightning-base-combobox-item//span[text()='%s']",
                label, option))).click();
    }
}
