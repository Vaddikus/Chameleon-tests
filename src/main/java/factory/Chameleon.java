package factory;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ScreenShotMaker;

public class Chameleon {

    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;
    public MessageTemplatesPage messageTemplatesPage;
    public AddEditTemplate addEditeTemplate;
    public ScreenShotMaker screenShotMaker;

    public Chameleon(WebDriver driver) {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        messageTemplatesPage = new MessageTemplatesPage(driver);
        addEditeTemplate = new AddEditTemplate(driver);
        screenShotMaker = new ScreenShotMaker(driver);
    }
}
