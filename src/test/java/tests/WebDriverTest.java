package tests;
import Factory.Fixtures;
import Factory.PageGenerator;
import Factory.WebDriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.List;


public class WebDriverTest {

    public WebDriver driver;

    public List<String> firstList;
    public List<String> secondList;

    @Test
    public void getRowFromTable() throws Exception {
        driver = WebDriverFactory.getDriver("chrome");

        PageGenerator pages = new PageGenerator(driver);
        pages.loginPage.open("https://staging-sbtech.chameleon360.net");
        pages.loginPage.logIn("vadym_h", "QAqa123!");
        pages.homePage.openSubMenuItem("Communications", "Message Templates");
        pages.homePage.clickSearchButton();
        firstList = pages.homePage.readDataFromCells();
        pages.homePage.searchWithData(firstList);
        Thread.sleep(500);
        pages.homePage.clickSearchButton();
        secondList = pages.homePage.readDataFromCells();
        Fixtures.tearDown(driver);
    }


}
