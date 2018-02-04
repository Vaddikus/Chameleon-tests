package factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ClassNameUtil;


public class WebDriverFactory {

    static Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vadym\\Documents\\drivers\\chromedriver.exe");
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();
        }
    }


}

