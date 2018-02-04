package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Navigation {


    public static void scrollToElement(WebDriver driver, WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static void scrollToBottom(WebDriver driver) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }


}
