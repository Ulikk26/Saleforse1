package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AccountsPage;
import pages.LoginPage;
import pages.NewAccountModal;
import utils.AllureUtils;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    NewAccountModal newAccountModal;
    LoginPage loginPage;
    AccountsPage accountsPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("fireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        newAccountModal = new NewAccountModal(driver);
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.takeScreenshot(driver);
        }
        driver.quit();
    }
}