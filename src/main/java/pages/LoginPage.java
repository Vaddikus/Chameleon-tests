package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "Username")
    WebElement loginField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    WebElement logButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void logIn(String login, String pass){
        fillField(loginField, login);
        fillField(passwordField, pass);
        click(logButton);
    }
}
