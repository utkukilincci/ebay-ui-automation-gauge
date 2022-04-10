package pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethods {

    private final By USERNAME_INPUT = By.id("userid");
    private final By CONTINUE_BUTTON = By.id("signin-continue-btn");
    private final By PASSWORD_INPUT = By.id("pass");
    private final By SIGN_IN_BUTTON = By.id("sgnBt");

    @Step("Sign in with <username> and <password>")
    public void login(String username, String password) {
        setText(USERNAME_INPUT, username);
        click(CONTINUE_BUTTON);
        setText(PASSWORD_INPUT, password);
        click(SIGN_IN_BUTTON);
    }
}
