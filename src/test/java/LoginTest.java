import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.LoginPage;

public class LoginTest {

    @Test
    public void loginWithValidCredentialsShowsSuccessMessage() {
        Playwright playwright = null;
        Browser browser = null;

        try {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();
            LoginPage loginPage = new LoginPage(page);

            loginPage.navigateToLoginPage();
            loginPage.login();

            String successMessage = loginPage.getSuccessMessage();
            Assert.assertTrue(
                    successMessage.contains("Logged In Successfully"),
                    "Expected the successful-login message, but found: " + successMessage);
        } finally {
            try {
                if (browser != null) {
                    browser.close();
                }
            } finally {
                if (playwright != null) {
                    playwright.close();
                }
            }
        }
    }
}