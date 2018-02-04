package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    public WebDriver driver;
    //TODO: need move in other class


    public BasePage(WebDriver driver) {
        this.driver = driver;
        //TODO: the same
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    public void click(WebElement element) {
        element.click();
    }

    public void fillField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
