package tests.usageTests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CommonPageElements;

public class Navigation {

    private WebDriver driver;
    private String pageAddress;
    CommonPageElements commonPageElements;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser","width","height","pageAddress"})
    public void setUpBrowser(String browser, int width, int height, String pageAddress){
        SetBrowser setBrowser = new SetBrowser();
        this.driver = setBrowser.setBrowser(browser, width, height, pageAddress);
        this.pageAddress = pageAddress;
        commonPageElements = new CommonPageElements(driver, pageAddress);
    }

    @Test
    public void aaaa() {
        System.out.println("testtttttttttttttttttt");
    }

    @AfterTest
    public void backToMainPage(){
        commonPageElements.backToMainPage();
    }

    @AfterSuite
    public void end(){
        driver.quit();
    }

}
