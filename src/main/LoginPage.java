package page;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    String username = "student";
    String password = "Password123";
    String submitBtn = "#submit";

    public void navigate() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");
    }

    public void login(String user, String pass) {

        page.fill(username, user);
        page.fill(password, pass);
        page.click(submitBtn);
    }

    public String getTitle() {
        return page.title();
    }
}