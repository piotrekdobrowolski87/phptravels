package pages.allPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Page {

    @FindBy(how = How.CLASS_NAME, using = "right carousel-control visible-lg visible-md")
    private WebElement moveRight;

    @FindBy(how = How.CLASS_NAME, using = "left carousel-control visible-lg visible-md")
    private WebElement moveLeft;

    @FindBy(how = How.XPATH, using= "//*[@class = 'carousel-inner fadeIn animated']/child::div")
    private List<WebElement> allPromoSectionBackground;

    @FindBy(how = How.CLASS_NAME, using= "citem home-slider hero hidden-xs hidden-sm active")
    private WebElement  activePromoSectionBackground;

    private String promoSectionNavigationBackground = "rgba(0, 0, 0, 0.2)";
    private Duration waitForNavigationBackground = Duration.ofSeconds(1);


    public HomePage(WebDriver driver){
        super(driver);
        setTitle("PHPTRAVELS | Travel Technology Partner");
        setPageUrl("https://www.phptravels.net/");
        setHyperlinkName("home");

        PageFactory.initElements(getDriver(),this);
    }

    public void checkNavigationBarBackgroundLeft(){
        checkNavigationBarBackground(moveLeft);
        System.out.println("Left navigation bar background is ok");
    }

    public void checkNavigationBarBackgroundRight(){
        checkNavigationBarBackground(moveRight);
        System.out.println("Right navigation bar background is ok");
    }

    public void checkPromoSectionBackground(){

        int amountBackgrounds = allPromoSectionBackground.size();
        System.out.println(amountBackgrounds + " !!!!!!!!!!!!!!");

        List<String> allBackgroundsUrl = new ArrayList<>(amountBackgrounds);

        for(WebElement background : allPromoSectionBackground){
            allBackgroundsUrl.add(background.getAttribute("src"));
            System.out.println();
        }

    }







    private void checkNavigationBarBackground(WebElement navigationBar) {

        Actions builder = new Actions(getDriver());
        Action mouseOverRight = builder.moveToElement(navigationBar)
                .pause(waitForNavigationBackground)
                .build();
        mouseOverRight.perform();

        String actualBackground = navigationBar.getCssValue("background-color");

       Assert.assertEquals(actualBackground, promoSectionNavigationBackground, "Promo section navigation bar has wrong background");
       }
}
