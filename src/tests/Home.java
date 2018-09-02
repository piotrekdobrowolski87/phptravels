package tests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CommonPageElements;
import pages.allPages.HomePage;


public class Home {

    private WebDriver driver;
    private CommonPageElements commonPageElements;
    private HomePage homePage;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "width", "height", "pageAddress"})
    public void setUpBrowser(String browser, int width, int height, String pageAddress) {

        SetBrowser setBrowser = new SetBrowser();
        this.driver = setBrowser.setBrowser(browser, width, height, pageAddress);
        homePage = new HomePage(this.driver);
        commonPageElements = new CommonPageElements(this.driver);
    }

    @Test (priority = 0)
    public void checkNavigationBarBackgroundLeft() {

        commonPageElements.waitForPreloader();
        homePage.checkNavigationBarBackgroundLeft();
    }

    @Test (priority = 1)
    public void checkNavigationBarBackgroundRight(){
        homePage.checkNavigationBarBackgroundRight();
    }

    @Test (priority = 2)
    public void checkPromoSectionBackgroundRight(){
        homePage.checkPromoSectionBackgroundRight();
    }

    @Test (priority = 3)
    public void checkPromoSectionBackgroundLeft(){
        homePage.checkPromoSectionBackgroundLeft();
    }

    @AfterSuite(alwaysRun = true)
    public void end() {
        driver.quit();
    }
}
