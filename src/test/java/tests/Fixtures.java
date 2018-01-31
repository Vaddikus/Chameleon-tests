package tests;

import factory.Chameleon;
import factory.WebDriverFactory;
import org.apache.log4j.Logger;
import org.junit.gen5.api.AfterAll;
import org.junit.gen5.api.AfterEach;
import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.BeforeEach;
import utils.ClassNameUtil;

public class Fixtures {

    static Chameleon chameleon;
    private static final Logger log =
            Logger.getLogger(ClassNameUtil.getCurrentClassName());


    @BeforeAll
    public void setUpBeforeAll(){
        chameleon = new Chameleon(WebDriverFactory.getDriver("chrome"));
        log.info("<=== Start tests ===>");
    }

    @BeforeEach
    public void setUp(){
        //TODO: your tests should be modular and independent
    }

    @AfterEach
    public void tearDown(){

    }

    @AfterAll
    public void tearDownAfterAll(){
        //TODO: pls thinks how you can implement this method
        //WebDriverFactory.dismissAll();
        log.info("<=== End of tests ===>");
    }
}
