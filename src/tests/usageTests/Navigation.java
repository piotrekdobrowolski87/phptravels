package tests.usageTests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CommonPageElements;
import pages.Page;
import pages.allPages.BlogPage;

public class Navigation {

    private WebDriver driver;
    private String pageAddress;
    private CommonPageElements commonPageElements;
    private String actualUrl;
    private String expectedUrl;
    private String actualTitle;
    private String expectedTitle;


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

    @Test
    public void blogTest(){
        Page blogPage = new BlogPage();
        System.out.println(blogPage.getPageTitle()+ " " + blogPage.getPageUrl() );

    }

    @AfterSuite
    public void end(){
        driver.quit();
    }

}
