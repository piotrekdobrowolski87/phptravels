package tests.usageTests;

import common.Element;
import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CommonPageElements;
import pages.Page;
import pages.allPages.HotelsPage;
import pages.usageTests.NavigationSection;

import java.util.List;

public class Navigation {

    private WebDriver driver;
    private String pageAddress;
    private CommonPageElements commonPageElements;
    private NavigationSection navigationSection;
    private int invocationCount = 1;



    @BeforeTest(alwaysRun = true)
    @Parameters({"browser","width","height","pageAddress"})
    public void setUpBrowser(String browser, int width, int height, String pageAddress){
        SetBrowser setBrowser = new SetBrowser();
        this.driver = setBrowser.setBrowser(browser, width, height, pageAddress);
        this.pageAddress = pageAddress;
        this.commonPageElements = new CommonPageElements(driver);
        this.navigationSection = new NavigationSection(driver);
    }

    @Test
    public void checkAmountOfNavigationElements() {
        Assert.assertTrue(navigationSection.checkAmountOfNavigationElements(), "Top navigation menu has more/less elements than expected");
        System.out.println("Top navigation menu has expected number of elements");
    }

    @Test(invocationCount = 8)
    public void checkNavigation(){
        List<WebElement> topNavigationMenu = commonPageElements.getTopNavigationMenu();

        if(invocationCount == topNavigationMenu.size()) {
            invocationCount = 0;
        }

            WebElement menuElement = topNavigationMenu.get(invocationCount);
            String menuElementName = menuElement.getText()
                    .trim()
                    .toLowerCase();

            menuElement.click();

            NavigationSection navigationSection = new NavigationSection(driver);
            Page page = navigationSection.getPage(menuElementName);


            String expectedUrl = page.getPageUrl();
            String actualUrl = driver.getCurrentUrl();

            System.out.println("1. " + expectedUrl + "  |   2. " + actualUrl);

            String expectedTitle = page.getPageTitle();
            String actualTitle = driver.getTitle();

            System.out.println("1. " + expectedTitle + "  |   2. " + actualTitle);

            Assert.assertEquals(actualUrl, expectedUrl, "Wrong page URL");
            System.out.println("Page Url - ok");

            Assert.assertEquals(actualTitle, expectedTitle, "Wrong page title");
            System.out.println("Page title - ok");

            invocationCount++;
    }

    @AfterTest
    public void backToMainPage(){
        //commonPageElements.backToMainPage();
    }

    @AfterSuite
    public void end(){
        driver.quit();
    }

}
