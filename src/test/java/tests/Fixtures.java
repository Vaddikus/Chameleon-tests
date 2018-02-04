package tests;

import factory.Chameleon;
import factory.WebDriverFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ClassNameUtil;


public class Fixtures {


    private static final Logger log =
            Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static Chameleon chameleon;

    @BeforeSuite
    public static void setUpBeforeAll() {

        log.info("<=== Start tests ===>");
    }


    @BeforeClass
    public void setUp() {
        //TODO: your tests should be modular and independent
        chameleon = new Chameleon(WebDriverFactory.getDriver("chrome"));


    }

    @AfterClass
    public void tearDown() {
        chameleon.basePage.driver.quit();
        chameleon.homePage.driver.quit();
        chameleon.loginPage.driver.quit();
        chameleon.addEditeTemplate.driver.quit();
        chameleon.messageTemplatesPage.driver.quit();
    }

    @AfterSuite
    public static void tearDownAfterAll() {
        //TODO: pls thinks how you can implement this method


//        WebDriverFactory.dismissAll();
        log.info("<=== End of tests ===>");
    }
}
