package tests;

import org.junit.gen5.api.Test;

import java.util.List;


public class WebDriverTest extends Fixtures{
    @Test
    public void getRowFromTable() {
        chameleon.loginPage.open("https://staging-sbtech.chameleon360.net");
        chameleon.loginPage.logIn("vadym_h", "QAqa123!");

        chameleon.homePage.openSubMenuItem("Communications", "Message Templates");
        chameleon.homePage.clickSearchButton();

        List<String> firstList = chameleon.homePage.readDataFromCells();
        chameleon.homePage.searchWithData(firstList);
    }
}
