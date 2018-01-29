package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(how = How.ID, using = "Username")
    WebElement loginField;
    @FindBy(how = How.ID, using = "Password")
    WebElement passwordField;
    @FindBy(how = How.CSS, using = "input[type='submit']")
    WebElement logButton;



    public void open(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }


         public void logIn(String login, String pass){
         write(loginField, login);
         write(passwordField, pass);
         click(logButton);
//         return new PageFactory().initElements(driver,HomePage.class);
     }



//     public void logIn(){
//         write(loginField, "garaschuck@gmail.com");
//         write(password, "bigus-figus");
//         click(logButton);
////         return new PageFactory().initElements(driver,HomePage.class);
//     }
//
//
//    @FindBy(how = How.LINK_TEXT, using = "Vadym Harashchuk")
//    WebElement linkToPage;
//    @FindBy(how = How.LINK_TEXT, using = "Friends")
//    WebElement friends;
//    @FindBy(how = How.CLASS_NAME, using = "inputtext")
//    WebElement search;
//
//    public void searchFriend(String friendName){
//        click(linkToPage);
//        click(friends);
//        write(search, friendName);
//
//    }




}
