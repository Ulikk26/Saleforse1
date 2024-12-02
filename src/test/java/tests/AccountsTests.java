package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AccountsTests extends BaseTest {

    @Test
    @Description("Проверка создания нового акаунта")
    public void checkCreateAccount() {
        loginPage.openLoginPage();
        loginPage.login("tborodich@tms.sandbox", "Password001");
        accountsPage.openAccountsPage();
        accountsPage.clickButtonNew();
        newAccountModal.createAccount("Julia1", "TMS", "12345", "https://www.goodmoon.com/",
                "Other","Apparel", "70000", "Hot", "37529111111111", "125454",
                "https://www.goodmoon.com/","OK", "Other", "Ivan", "123", "Chkalova",
                "Minsk", "RB", "12345", "Belarus", "Esenina", "Minsk",
                "RB", "456","Belarus", "High", "01.01.2025",
                "123", "Yes", "Gold","123456789", "Yes",
                "It's COOL");
        newAccountModal.clickButtonSave();
    }
}
