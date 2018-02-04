package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenShotMaker;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "nav#MainMenu a[title='Show/Hide content']")
    WebElement mainMenu;

    @FindBy(id = "btnSearch")
    WebElement searchButton;

    @FindBy(css = "span.dx-datagrid-nodata")
    WebElement noData;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void openMenuSection(String menuItem) {
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(mainMenu));
        mainMenu.click();
        driver.findElement(By.cssSelector("li.collapsable-menu--item > a[title='" + menuItem + "']")).click();
    }

    public void openSubMenuItem(String menuItem, String item) {
        openMenuSection(menuItem);
        driver.findElement(By.cssSelector("li.collapsable-menu--item > a[title='"
                + menuItem + "']~ ul li a[title='"
                + item + "']")).click();

        new ScreenShotMaker(driver)
                .takeScreenShot(getClass().getName());
    }




}
