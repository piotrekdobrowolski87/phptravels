package pages;

import common.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import java.util.List;

public class CommonPageElements {

    WebDriver driver;
    Element element;

    @FindBy(how = How.CLASS_NAME, using = "navbar-brand")
    @CacheLookup
    private WebElement navigationBarImage;

    //top navigation menu
    @FindBy(how = How.XPATH, using = "//*[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav']/li")
    @CacheLookup
    private List<WebElement> topNavigationMenu;

    //my account
    @FindBy(how = How.ID, using = "li_myaccount")
    //*[@class='nav navbar-nav navbar-right']//*[@id='li_myaccount'] xpath
    @CacheLookup
    private WebElement myAccount;

    //money
    @FindBy(how = How.XPATH, using = "//*[@class='nav navbar-nav navbar-right']/ul//li[2][@class='dropdown']")
    @CacheLookup
    private WebElement money;

    //language
    @FindBy(how = How.XPATH, using = "//*[@class='nav navbar-nav navbar-right']/ul//li[1][@class='dropdown']")
    @CacheLookup
    private WebElement language;


    public CommonPageElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void backToMainPage(String homePageUrl){
        element = new Element("Navigation bar image", navigationBarImage);
        element.cickElement();
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, homePageUrl, "Wrong main page address");

        System.out.println("You back to main page");
    }

    public List<WebElement> getTopNavigationMenu() {
        return topNavigationMenu;
    }
}
