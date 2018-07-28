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

        if(invocationCount == navigationSection.getAmountOfNavigationElements()) {
            invocationCount = 0;
        }

            WebElement menuElement = topNavigationMenu.get(invocationCount);
            String menuElementName = menuElement.getText()
                    .trim()
                    .toLowerCase();

            menuElement.click();

            invocationCount++;

            NavigationSection navigationSection = new NavigationSection(driver);
            Page page = navigationSection.getPage(menuElementName);

            navigationSection.checkAddressAndTitle(page);
    }

    @AfterTest
    public void backToMainPage(){

        if(invocationCount != 0) {
            commonPageElements.backToMainPage();
        }
    }

    @AfterSuite
    public void end(){
        driver.quit();
    }

}
