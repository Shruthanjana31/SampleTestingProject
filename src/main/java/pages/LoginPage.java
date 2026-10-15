package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

import java.util.Objects;

public class LoginPage {

    private static final String LOGIN_URL = "https://practicetestautomation.com/practice-test-login/";
    private static final String USERNAME = "student";
    private static final String PASSWORD = "Password123";

    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator successMessage;

    public LoginPage(Page page) {
        this.page = Objects.requireNonNull(page, "page must not be null");
        this.usernameInput = page.locator("#username");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#submit");
        this.successMessage = page.locator("h1.post-title");
    }

    public void navigateToLoginPage() {
        page.navigate(LOGIN_URL);
    }

    public void enterUsername() {
        usernameInput.fill(USERNAME);
    }

    public void enterPassword() {
        passwordInput.fill(PASSWORD);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login() {
        enterUsername();
        enterPassword();
        clickLogin();
    }

    public String getSuccessMessage() {
        return successMessage.innerText();
    }
}