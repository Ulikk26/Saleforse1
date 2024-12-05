package tests;

import DTO_models.Account;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static DTO_models.AccountFactory.getAccount;

public class AccountsTests extends BaseTest {

    Account account = new Account("Zhdanova", "", "", "", "", "", "",
            "", "", "", "", "", "", "");

    @Test(testName = "Создание нового аккаунта", description = "Создание нового аккаунта")
    @Description("Создание нового аккаунта")
    public void checkCreateAccount() {
        Account getAccount;
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password001")
                .open()
                .isPageOpened()
                .clickButton("New")
                .createAccount(getAccount("www.cool", "Hot", "Prospect", "Agriculture", "Public","Julia4"))
                .clickActionButton("Save")
                .checkSuccessMassage();
    }

    @Test(testName = "Редактирование данных аккаунта", description = "Редактирование данных аккаунта")
    @Description("Редактирование данных аккаунта")
    public void changeAccountInput() {
        Account getAccount;
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password001")
                .open()
                .isPageOpened()
                .inputSearchField("Julia")
                .clickActionButton("Edit", "Julia")
                .editWindowIsDisplayed()
                .editAccount(account, "Zhdanova", "Warm")
                .clickActionButton("Save")
                .checkSuccessMassage();
    }
}
