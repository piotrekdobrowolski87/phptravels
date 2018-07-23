package tests.usageTests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CommonPageElements;
import pages.usageTests.NavigationSection;

public class Navigation {

    private WebDriver driver;
    private String pageAddress;
    private CommonPageElements commonPageElements;
    private NavigationSection navigationSection;
    private int invocationCount = 0;


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

    @Test(invocationCount = 7)
    public void checkNavigation(){
        WebElement menuElement = commonPageElements.getTopNavigationMenu()
                .get(invocationCount);

        this.invocationCount++;
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
