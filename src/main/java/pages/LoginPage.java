package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "Username")
    WebElement loginField;

    @FindBy(how = How.ID, using = "Password")
    WebElement passwordField;

    @FindBy(how = How.CSS, using = "input[type='submit']")
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
