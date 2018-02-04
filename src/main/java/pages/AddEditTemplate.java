package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Navigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddEditTemplate extends BasePage {

    @FindBy(id = "General_txtName")
    WebElement nameField;

    @FindBy(id = "cs-General_ddlWHLFilter")
    WebElement filterOperators;

    @FindBy(id = "cs-General_ddlBrands")
    WebElement filterBrands;

    @FindBy(id = "cs-General_ddlChannel")
    WebElement filterChannel;

    @FindBy(id = "cs-General_ddlLanguage")
    WebElement filterLanguage;

    @FindBy(id = "cs-General_ddlMode")
    WebElement filterMode;

    @FindBy(id = "General_txtDescription")
    WebElement textDesription;

    @FindBy(id = "cs-General_ddlCategory")
    WebElement filterCategory;

    @FindBy(css = "div[title='10bet-UK']")
    WebElement operator10BetUk;

    @FindBy(css = "div[title='Ukrainian']")
    WebElement langUkrainian;

    @FindBy(css = "div[title='Armenian']")
    WebElement langArmenian;

    @FindBy(css = "div[title='Automatic']")
    WebElement modeAutomatic;

    @FindBy(css = "div[title='Manual']")
    WebElement modeManual;

    @FindBy(css = "div[title='MFA']")
    WebElement triggerMFA;

    @FindBy(id = "Email_FromName")
    WebElement fromName;

    @FindBy(id = "Email_FromEmail")
    WebElement fromMail;

    @FindBy(id = "4_1_Title")
    WebElement titleMail;

    @FindBy(xpath = "//html/body/p")
    WebElement bodyMail;

    @FindBy(id = "btnSaveTemplate")
    WebElement savetemplateButton;



    public AddEditTemplate(WebDriver driver) {
        super(driver);
    }

    public void createTemplateAllChannels() throws InterruptedException {
        List<List<String>> values = new ArrayList<>();

        //Fill Name textfield
        String name = "VadymTest";
        nameField.clear();
        nameField.sendKeys(name);
        values.add(Arrays.asList(name));

        //Choose operator
        filterOperators.click();
        operator10BetUk.click();
        values.add(Arrays.asList(operator10BetUk.getText()));

        //Choose languages
        filterLanguage.click();
        langUkrainian.click();
        langArmenian.click();
        values.add(Arrays.asList(langArmenian.getText(),langUkrainian.getText()));

        //Choose modes
        filterMode.click();
        modeAutomatic.click();
        values.add(Arrays.asList(modeAutomatic.getText()));

//
//        (new WebDriverWait(driver,15))
//                .until(ExpectedConditions.attributeContains(By.cssSelector("div#cs-General_ddlMode input"), "placeholder", "Automatic"));
        (new WebDriverWait(driver,5))
                .until(ExpectedConditions.elementToBeClickable(filterMode));
        filterCategory.click();
        (new WebDriverWait(driver,5))
                .until(ExpectedConditions.elementToBeClickable(triggerMFA));
        triggerMFA.click();
        values.add(Arrays.asList(triggerMFA.getText()));

        //Fill description
        String description = "The test description...";
        textDesription.clear();
        textDesription.sendKeys(description);
        values.add(Arrays.asList(description));

        //Fill fromName
        String from = "Vadym Test QA";
        fromName.clear();
        fromName.sendKeys(from);
        values.add(Arrays.asList(from));

        //Fill fromName
        String mail = "test@ua.com";
        fromMail.clear();
        fromMail.sendKeys(mail);
        values.add(Arrays.asList(from));

        //Fill body
        WebElement frame = driver.findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset"));
//        Navigation.scrollToElement(driver, frame);
//        String body = "Hello is a text template";
//        driver.switchTo().frame(frame);
//        Thread.sleep(500);
//        bodyMail.sendKeys(body);
//        driver.switchTo().defaultContent();

        //Save template
        Navigation.scrollToBottom(driver);
        savetemplateButton.click();


    }

}
