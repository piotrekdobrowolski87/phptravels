package tests.usageTests;

import common.CommonMethods;
import common.SetBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CommonPageElements;
import pages.Page;
import pages.usageTests.NavigationSection;

import java.util.List;

public class Navigation {

    private WebDriver driver;
    private CommonPageElements commonPageElements;
    private NavigationSection navigationSection;
    private CommonMethods commonMethods;
    private WebElement preloader;
    private List<WebElement> topNavigationMenu;
    private WebElement menuElement;
    private int invocationCount = 1;
    private String previousTitle;
    private String previousURL;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "width", "height", "pageAddress"})
    public void setUpBrowser(String browser, int width, int height, String pageAddress) {
        SetBrowser setBrowser = new SetBrowser();
        this.driver = setBrowser.setBrowser(browser, width, height, pageAddress);
        this.commonPageElements = new CommonPageElements(driver);
        this.navigationSection = new NavigationSection(driver);
        this.commonMethods = new CommonMethods(driver);
    }

    @Test
    public void checkAmountOfNavigationElements() {
        Assert.assertTrue(navigationSection.checkAmountOfNavigationElements(), "Top navigation menu has more/less elements than expected");
        System.out.println("Top navigation menu has expected number of elements");

        preloader = commonPageElements.getPreloader();

        navigationSection.waitForPreloader(preloader);

        previousTitle = driver.getTitle();
        previousURL = driver.getCurrentUrl();

        topNavigationMenu = commonPageElements.getTopNavigationMenu();
    }

    @Test(invocationCount = 8)
    public void checkNavigation() {

        navigationSection.waitForMenuElements();
        menuElement = topNavigationMenu.get(invocationCount);

        String hyperlinkName = commonMethods.getTextFromWebElement(menuElement);
        menuElement.click();

        navigationSection.waitForNextPage(previousTitle,previousURL);
        navigationSection.waitForPreloader(preloader);

        Page page = navigationSection.getPage(hyperlinkName);

        navigationSection.checkAddressAndTitle(page);

        afterPageChange();

        navigationSection.backToMainPage(commonPageElements
                .waitNavigationBarImage());

    }

    @AfterSuite
    public void end() {
        driver.quit();
    }

    private void afterPageChange(){

        if(invocationCount < navigationSection.getAmountOfNavigationElements() - 1)
        {
            invocationCount++;
        }
        else {
            invocationCount = 0;
        }

        previousTitle = driver.getTitle();
        previousURL = driver.getCurrentUrl();
    }

}
