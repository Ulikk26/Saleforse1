package steps;

import DTO_models.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountsPage;
import pages.EditModal;
import pages.NewAccountModal;

public class AccountStep {

    AccountsPage accountsPage;
    NewAccountModal newAccountModal;
    EditModal editModal;

    public AccountStep(WebDriver driver) {

        accountsPage = new AccountsPage(driver);
        newAccountModal = new NewAccountModal(driver);
        editModal = new EditModal(driver);
    }

    public void create(Account account, String name) {
        accountsPage.open();
        accountsPage.clickButton("New");
        newAccountModal.createAccount(account);
        newAccountModal.clickButton("Save");
        WebElement message = accountsPage.checkCreateSuccessMassage();
        Assert.assertTrue(message.isDisplayed(), "Сообщение об успешном создании аккаунта не отображается");
        Assert.assertEquals(accountsPage.checkNameCreatedAccount(), name, "Имя созданного аккаунта не соответствует ожидаемому результату");
    }

    public void edit(Account accountEdit, String name) {
        accountsPage.open();
        accountsPage.inputSearchField(name);
        accountsPage.clickActionButton("Edit", name);
        editModal.editWindowIsDisplayed();
        editModal.editAccount(accountEdit);
        editModal.clickButton("Save");
        WebElement message = accountsPage.checkSaveSuccessMassage();
        Assert.assertTrue(message.isDisplayed(), "Сообщение об успешном редактировании аккаунта не отображается");
    }
}
