package tests.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputHelper {

    public static void write(WebDriver driver, String label, String text) {
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input)", label)))
                .sendKeys(text);
    }
}
