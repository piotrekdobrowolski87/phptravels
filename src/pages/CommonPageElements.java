package pages;

import common.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CommonPageElements {

    WebDriver driver;
    Element element;
    String mainPageAddress = "https://www.phptravels.net/";

    public CommonPageElements(WebDriver driver, String pageAddress){
        this.driver = driver;
        this.mainPageAddress = pageAddress;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "navbar-brand")
    @CacheLookup
    private WebElement navigationBarImage;

    //top navigation menu
    @FindBy(how = How.XPATH, using = "//*[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav']/li")
    @CacheLookup
    private List topNavigationMenu;

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


    public void checkAddressAndTitle(String pageAddress, String title, WebDriver driver){
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, pageAddress, "Page address is different than expected");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , title, "Page title is different than expected");
    }

    public void backToMainPage(){
        element = new Element("Navigation bar image", navigationBarImage);
        element.cickElement();
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, mainPageAddress, "Wrong main page address");

        System.out.println("You back to main page");
    }
}
