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
        newAccountModal.createAccount("Julia", "TMS", "12345", "https://julia", "Other",
                "Apparel", "70000", "Hot", "37529111111111", "125454", "https://julia",
                "OK", "Other", "Ivan", "123", "Chkalova", "Minsk", "RB",
                "12345", "Belarus", "Esenina", "Minsk", "RB", "456",
                "Belarus", "High", "01.01.2025", "123456", "Yes", "Gold",
                "123456789", "Yes", "It's COOL");
    }
}
