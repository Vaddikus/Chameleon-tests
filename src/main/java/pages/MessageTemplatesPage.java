package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MessageTemplatesPage extends BasePage {

    @FindBy(css = "nav#MainMenu a[title='Show/Hide content']")
    WebElement mainMenu;

    @FindBy(css = "div#cs-ddlCategories")
    WebElement filterCategories;

    @FindBy(css = "div#cs-ddlOperators")
    WebElement filterOperators;

    @FindBy(css = "div#cs-ddlBrands")
    WebElement filterBrands;

    @FindBy(css = "div#cs-ddlChannels")
    WebElement filterChannels;

    @FindBy(css = "div#cs-ddlStatus")
    WebElement filterStatus;

    @FindBy(css = "div#cs-Language")
    WebElement filterLanguages;

    @FindBy(id = "btnSearch")
    WebElement searchButton;

    @FindBy(css = "span.dx-datagrid-nodata")
    WebElement noData;

    @FindBy(css = "div.dx-scrollable-content tr.dx-row:first-child td:nth-child(-n+9)")
    List<WebElement> firstRowData;

    @FindBy(id = "btnCreateTemplate")
    WebElement createTemplateButton;



    public MessageTemplatesPage(WebDriver driver) {
        super(driver);
    }


    public void createTemplate() {
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(createTemplateButton));
        createTemplateButton.click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }

    public void clickSearchButton() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

    }


    public List<String> readDataFromCells() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(noData, "No data")));

        List<String> sells = new ArrayList<>();
        List<WebElement> firstRow = firstRowData;

        for (WebElement aFirstRow : firstRow)
            sells.add(aFirstRow.getText());

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

        if (sells.get(5).length() > 1) {
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
