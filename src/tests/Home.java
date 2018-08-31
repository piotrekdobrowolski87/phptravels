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

import java.time.Duration;


public class Home {

    private WebDriver driver;
    private String moveRightActivBackground = "rgba(0, 0, 0, 0.2)";

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

        WebElement aaa = homePage.getMoveRight();
        String bbb = aaa.getCssValue("background-color");

        System.out.println(bbb);

        Actions bulider = new Actions(driver);

        Action mousOverRight = bulider.moveToElement(aaa)
                .build();

        mousOverRight.perform();


        FluentWait wait = new WebDriverWait(driver,100)
                .pollingEvery(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.attributeToBe(aaa, "background-color","rgba(0, 0, 0, 0.2)"));

        String ccc = aaa.getCssValue("background-color");

        System.out.println(ccc);

        System.out.println();

    }

    @AfterSuite(alwaysRun = true)
    public void end() {
        driver.quit();
    }
}
