package factory;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utils.ScreenShotMaker;

public class Chameleon {

    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ScreenShotMaker screenShotMaker;

    public Chameleon(WebDriver driver) {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        screenShotMaker = new ScreenShotMaker(driver);
    }
}
