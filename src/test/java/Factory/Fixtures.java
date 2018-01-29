package Factory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fixtures {


    @BeforeAll
    public static void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vadym\\Documents\\drivers\\chromedriver.exe");
//        ChromeOptions ops = new ChromeOptions();
//        ops.addArguments("--disable-notifications");
//        driver = new ChromeDriver(ops);

    }

    @AfterAll
    public  static void tearDown(WebDriver driver){
        driver.quit();
    }

}
