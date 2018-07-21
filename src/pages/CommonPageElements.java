package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonPageElements {

    WebDriver driver;

    public CommonPageElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "navbar-brand")
    @CacheLookup
    private WebElement navigationBarImage;

    //top navigation menu
    //*/ul[@class='nav navbar-nav']/li

    public void checkAddressAndTitle(String pageAddress, String title, WebDriver driver){
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, pageAddress, "Page address is different than expected");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , title, "Page title is different than expected");
    }
}
