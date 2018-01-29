package Factory;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class PageGenerator {

    public LoginPage loginPage;
    public HomePage homePage;




    public PageGenerator(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

}

