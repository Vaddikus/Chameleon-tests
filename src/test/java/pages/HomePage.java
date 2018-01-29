package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;



public class HomePage extends BasePage {




    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "[title='Show/Hide content']")
    WebElement mainMenu;

    @FindBy(how = How.CSS, using = "div#cs-ddlCategories")
    WebElement filterCategories;

    @FindBy(how = How.CSS, using = "div#cs-ddlOperators")
    WebElement filterOperators;

    @FindBy(how = How.CSS, using = "div#cs-ddlBrands")
    WebElement filterBrands;

    @FindBy(how = How.CSS, using = "div#cs-ddlChannels")
    WebElement filterChannels;

    @FindBy(how = How.CSS, using = "div#cs-ddlStatus")
    WebElement filterStatus;

    @FindBy(how = How.CSS, using = "div#cs-Language")
    WebElement filterLanguages;

    @FindBy(how = How.ID, using = "btnSearch")
    WebElement searchButton;

    @FindBy(how = How.CSS, using = "span.dx-datagrid-nodata")
    WebElement noData;


    public void openMenuSection(String menuItem) {
        wait.until(ExpectedConditions.elementToBeClickable(mainMenu));
        mainMenu.click();
        driver.findElement(By.cssSelector("li.collapsable-menu--item > a[title='" + menuItem + "']")).click();
    }

    public void openSubMenuItem(String menuItem, String item) {
        openMenuSection(menuItem);
        driver.findElement(By.cssSelector("li.collapsable-menu--item > a[title='"
                + menuItem + "']~ ul li a[title='"
                + item + "']")).click();
        makeScreenshot();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

    }

    public List<String> readDataFromCells() {
        List<String> sells = new ArrayList<>();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(noData, "No data")));
        List<WebElement> firstRow = new ArrayList<>();
        firstRow = driver.findElements(By.cssSelector("div.dx-scrollable-content tr.dx-row:first-child td"));
        for (int i = 0; i < 9; i++) {
            sells.add(firstRow.get(i).getText());
        }
        return sells;
    }

    public void searchWithData(List<String> sells) {
        if (sells.get(1).length() > 1) {
            filterCategories.click();
            driver.findElement(By.cssSelector("div[title='" + sells.get(1) + "']")).click();
        }
        if (sells.get(4).length() > 1) {
            filterOperators.click();
            driver.findElement(By.cssSelector("div[title='" + sells.get(4) + "']")).click();
        }

        if (sells.get(5).length() > 1 ) {
            filterBrands.click();
            driver.findElement(By.cssSelector("div[title='" + sells.get(5) + "']")).click();
        }

        if (sells.get(6).length() > 1) {
            filterChannels.click();
            if (sells.get(6).contains(",")) {
                String[] channels = sells.get(6).split(",");
                for (String channel : channels) {
                    driver.findElement(By.cssSelector("div[title='" + channel + "']")).click();
                }
            }
            else  {
                driver.findElement(By.cssSelector("div[title='" + sells.get(6) + "']")).click();
            }
        }

        if (sells.get(7).length() > 1) {
            filterLanguages.click();
            if (sells.get(7).contains(",")) {
                String[] languages = sells.get(7).split(",");
                for (String lang : languages) {
                    driver.findElement(By.cssSelector("div[title='" + lang + "']")).click();
                }
            }
            else  {
                driver.findElement(By.cssSelector("div[title='" + sells.get(7) + "']")).click();
            }
        }

        if (sells.get(8).length() > 1 ) {
            filterStatus.click();
            driver.findElement(By.cssSelector("div[title='" + sells.get(8) + "']")).click();
        }


    }
}
