package tests;

import DTO_models.Account;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class AccountsTests extends BaseTest {

    Faker faker = new Faker();

    Account account1 = Account.builder()
            .accountName("julia55")
            .accountNumber("12345")
            .phone("33654")
            .fax(faker.phoneNumber().cellPhone())
            .accountSite("www.cool")
            .rating("Hot")
            .type("Prospect")
            .industry("Agriculture")
            .annualRevenue(faker.number().digit())
            .website(faker.internet().url())
            .tickerSymbol(faker.letterify("ABCD"))
            .ownership("Public")
            .employees(faker.number().digit())
            .parentAccount("Julia4")
            .build();

    Account account2 = Account.builder()
            .accountName("julia55")
            .accountNumber("12345")
            .phone("33654")
            .build();

    Account accountEdit = Account.builder()
            .accountName("Julia875")
            .rating("Warm")
            .build();

    @Test(testName = "Создание нового аккаунта", description = "Создание нового аккаунта")
    @Description("Создание нового аккаунта")
    public void checkCreateAccount() {
        log.info("Creating new account");
        Account getAccount;
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password001")
                .open()
                .isPageOpened()
                .clickButton("New")
                .createAccount(account2)
                .clickActionButton("Save")
                .checkCreateSuccessMassage();
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
                .editAccount(accountEdit)
                .clickActionButton("Save")
                .checkSaveSuccessMassage();
    }
}
