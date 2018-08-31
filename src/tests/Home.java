package tests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CommonPageElements;
import pages.allPages.HomePage;


public class Home {

    private WebDriver driver;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "width", "height", "pageAddress"})
    public void setUpBrowser(String browser, int width, int height, String pageAddress) {
        SetBrowser setBrowser = new SetBrowser();

        this.driver = setBrowser.setBrowser(browser, width, height, pageAddress);

    }

    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        CommonPageElements commonPageElements = new CommonPageElements(driver);

        commonPageElements.waitForPreloader();

        homePage.checkNavigationBarBackgroundLeft();
        homePage.checkNavigationBarBackgroundRight();

        homePage.checkPromoSectionBackground();



    }

    @AfterSuite(alwaysRun = true)
    public void end() {
        driver.quit();
    }
}
