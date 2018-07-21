package tests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main {

    private WebDriver driver;
    private String pageAddress;


    @BeforeTest (alwaysRun = true)
    @Parameters({"browser","width","height","pageAddress"})
    public void setUpBrowser(String browser, int width, int height, String pageAddress){
        SetBrowser setBrowser = new SetBrowser();
        this.driver = setBrowser.setBrowser(browser, width, height, pageAddress);
        this.pageAddress = pageAddress;
    }

    @AfterTest
    public void returnToMainPage(){
        System.out.println("AfterTest");
    }

    @Test
    public void pageAddressVerify(){
        Assert.assertEquals(driver.getCurrentUrl(), pageAddress, "Wrong page address");
        System.out.println("Page address ok");
    }

    @AfterSuite
    public void end(){
        driver.quit();
    }
}
