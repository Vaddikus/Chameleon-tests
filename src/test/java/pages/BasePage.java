package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class BasePage  {
    public WebDriver driver;
    public Wait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
       wait = new WebDriverWait(driver, 10);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void write(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String read(WebElement element) {
        return element.getText();
    }

    public void makeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Vadym\\Documents\\scrennshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }


}
