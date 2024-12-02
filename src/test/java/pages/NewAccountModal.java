package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.wrappers.ComboBox;
import tests.wrappers.Input;
import tests.wrappers.Picklist;
import tests.wrappers.Textarea;

public class NewAccountModal extends BasePage {

    private final By BUTTON_SAVE = By.xpath("//button[@name = 'SaveEdit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Создание нового акаунта со следующими параметрами :Account Name{name}, Parent Account {parentAccount}," +
            "Account Number {number}, ")
    public void createAccount(String name, String parentAccount, String number, String accountSite, String type,
                              String industry, String revenue, String rating, String phone, String fax, String website,
                              String symbol, String ownership,String employees, String sicCode, String street,
                              String city, String state, String zip, String country, String shippingStreet,
                              String shippingCity, String shippingState, String shippingZip, String shippingCountry,
                              String customerPriority, String date, String location, String active, String sla,
                              String slaSerialNumber, String opportunity,String description) {
        new Input(driver, "Account Name").write(name);
        new ComboBox(driver, "Parent Account").select(parentAccount);
        new Input(driver, "Account Number").write(number);
        new Input(driver, "Account Site").write(accountSite);
        new Picklist(driver, "Type").select(type);
        new Picklist(driver, "Industry").select(industry);
        new Input(driver, "Annual Revenue").write(revenue);
        new Picklist(driver, "Rating").select(rating);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new Input(driver, "Ticker Symbol").write(symbol);
        new Input(driver, "Website").write(website);
        new Input(driver, "Website").write(website);
        new Picklist(driver, "Ownership").select(ownership);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "SIC Code").write(sicCode);
        new Textarea(driver, "Billing Street").write(street);
        new Input(driver, "Billing City").write(city);
        new Input(driver, "Billing State/Province").write(state);
        new Input(driver, "Billing Zip/Postal Code").write(zip);
        new Input(driver, "Billing Country").write(country);
        new Textarea(driver, "Shipping Street").write(shippingStreet);
        new Input(driver, "Shipping City").write(shippingCity);
        new Input(driver, "Shipping State/Province").write(shippingState);
        new Input(driver, "Shipping Zip/Postal Code").write(shippingZip);
        new Input(driver, "Shipping Country").write(shippingCountry);
        new Picklist(driver, "Customer Priority").select(customerPriority);
        new Input(driver, "SLA Expiration Date").write(date);
        new Input(driver, "Number of Locations").write(location);
        new Picklist(driver, "Active").select(active);
        new Picklist(driver, "SLA").select(sla);
        new Input(driver, "SLA Serial Number").write(slaSerialNumber);
        new Picklist(driver, "Upsell Opportunity").select(opportunity);
        new Textarea(driver, "Description").write(description);
    }

    @Step("Нажатие на кнопку Save")
    public void clickButtonSave() {
        driver.findElement(BUTTON_SAVE).click();
    }
}
