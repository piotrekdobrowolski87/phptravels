package pages.allPages;

import common.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Page;

import java.time.Duration;
import java.util.List;

public class HomePage extends Page {

    @FindBy(how = How.XPATH, using = "//*[@class = 'right carousel-control visible-lg visible-md']")
    private WebElement moveRight;

    @FindBy(how = How.XPATH, using = "//*[@class = 'left carousel-control visible-lg visible-md']")
    private WebElement moveLeft;

    @FindBy(how = How.XPATH, using = "//*[@class = 'carousel-inner fadeIn animated']/child::div/img")
    private List<WebElement> allPromoSectionBackground;

    @FindBy(how = How.XPATH, using = "//*[@class = 'carousel-inner fadeIn animated']/child::div[contains(@class,'active')]/img")
    private WebElement activePromoSectionBackground;

    private String promoSectionNavigationBackground = "rgba(0, 0, 0, 0.2)";
    private int waitForNavigationBackground = 1;
    private CommonMethods commonMethods;
    private int amountBackgrounds;
    private Duration waitTimeout = Duration.ofSeconds(1);
    private Duration pollingTime = Duration.ofMillis(100);


    public HomePage(WebDriver driver) {
        super(driver);
        setTitle("PHPTRAVELS | Travel Technology Partner");
        setPageUrl("https://www.phptravels.net/");
        setHyperlinkName("home");

        PageFactory.initElements(getDriver(), this);
        commonMethods = new CommonMethods(getDriver());
        amountBackgrounds = allPromoSectionBackground.size();
    }

    public void checkNavigationBarBackgroundLeft() {
        checkNavigationBarBackground(moveLeft);
        System.out.println("Left navigation bar background is ok");
    }

    public void checkNavigationBarBackgroundRight() {
        checkNavigationBarBackground(moveRight);
        System.out.println("Right navigation bar background is ok");
    }

    public void checkPromoSectionBackgroundRight() {

        for (int x = 0; x < amountBackgrounds; x++) {

            checkActivePromoSectionBackground(x);
            if (x < amountBackgrounds - 1) {
                commonMethods.mouseOverWebElementAndClick(moveRight, waitTimeout);
                commonMethods.waitForInvisibilityOfWebElement(allPromoSectionBackground.get(x), waitTimeout, pollingTime);
            }
        }
        System.out.println("Promo section background move right ok");
    }

    public void checkPromoSectionBackgroundLeft() {

        for(int x = amountBackgrounds - 1; x >= 0; x--){

            checkActivePromoSectionBackground(x);
            commonMethods.mouseOverWebElementAndClick(moveLeft,waitTimeout);
            if(x > 0){
                commonMethods.waitForInvisibilityOfWebElement(allPromoSectionBackground.get(x),waitTimeout,pollingTime);
            }

        }
        System.out.println("Promo section background move left ok");
    }


    private void checkNavigationBarBackground(WebElement navigationBar) {

        commonMethods.mouseOverWebElement(navigationBar, waitForNavigationBackground);

        String actualBackground = navigationBar.getCssValue("background-color");

        Assert.assertEquals(actualBackground, promoSectionNavigationBackground, "Promo section navigation bar has wrong background");
    }

    private void checkActivePromoSectionBackground(int backgroundIndex){

        commonMethods.waitForVisibilityOfWebElement(activePromoSectionBackground,waitTimeout,pollingTime);
        boolean backgroundIsDisplayed = activePromoSectionBackground.isDisplayed();

        Assert.assertTrue(backgroundIsDisplayed, "Background is not displayed");


        String activeBackground = activePromoSectionBackground.getAttribute("src");
        String expectedBackground = allPromoSectionBackground.get(backgroundIndex)
                .getAttribute("src");

        Assert.assertEquals(activeBackground, expectedBackground, "Wrong background");

    }
}
