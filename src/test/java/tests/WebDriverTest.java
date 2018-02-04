package tests;

import factory.Chameleon;
import factory.WebDriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.List;


public class WebDriverTest extends Fixtures {




    @Test
    public void getRowFromTable() throws InterruptedException {
        chameleon.loginPage.open("https://staging-sbtech.chameleon360.net");
        chameleon.loginPage.logIn("vadym_h", "QAqa123!");

        chameleon.homePage.openSubMenuItem("Communications", "Message Templates");
        chameleon.messageTemplatesPage.createTemplate();
        chameleon.addEditeTemplate.createTemplateAllChannels();
        chameleon.messageTemplatesPage.clickSearchButton();

//        List<String> firstList = chameleon.messageTemplatesPage.readDataFromCells();
//        chameleon.messageTemplatesPage.searchWithData(firstList);
    }
}
