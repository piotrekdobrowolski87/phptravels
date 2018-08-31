package pages;

import common.MyFunction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonPageElements {

    private WebDriver driver;
    private WebDriverWait commonPageElementsWait;
    private int timeout = 5;

    @FindBy(how = How.CLASS_NAME, using = "navbar-brand")
    private WebElement navigationBarImage;

    //top navigation menu
    @FindBy(how = How.XPATH, using = "//*[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav']/li")
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

    //preloader
    @FindBy(how = How.ID, using = "preloader")
    private WebElement preloader;


    public CommonPageElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonPageElementsWait = new WebDriverWait(this.driver,this.timeout);
    }

    public List<WebElement> getTopNavigationMenu() {
        return topNavigationMenu;
    }

    public WebElement getPreloader() {
        return preloader;
    }

    public WebElement waitNavigationBarImage(){

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        MyFunction myFunction = new MyFunction();
        myFunction.setWebElement(navigationBarImage);

        WebElement clicableElement = wait.until(myFunction);

        return clicableElement;
    }

    public void waitForMenuElements(){

        commonPageElementsWait.until(ExpectedConditions.visibilityOfAllElements(topNavigationMenu));
    }

    public void waitForPreloader(){

        commonPageElementsWait.until(ExpectedConditions.attributeContains(preloader, "style", "display: none;"));
    }
}
