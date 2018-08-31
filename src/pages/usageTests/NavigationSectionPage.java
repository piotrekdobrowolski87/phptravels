package pages.usageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CommonPageElements;
import pages.Page;
import pages.allPages.*;

import java.util.ArrayList;
import java.util.List;

public class NavigationSectionPage {
    private WebDriver driver;
    private CommonPageElements commonPageElements;
    private int amountOfNavigationElements = 8;
    private List<WebElement> topNavigationMenu;
    private WebDriverWait navigationWait;
    private int navigationTimeout = 5;

    public NavigationSectionPage(WebDriver driver) {
        this.driver = driver;
        commonPageElements = new CommonPageElements(this.driver);
        this.navigationWait = new WebDriverWait(this.driver, this.navigationTimeout);
    }

    public boolean checkAmountOfNavigationElements() {
        boolean result = false;

        topNavigationMenu = commonPageElements.getTopNavigationMenu();

        if (amountOfNavigationElements == getActualAmountOfNavigationElements()) {
            result = true;
        }

        return result;
    }

    public void waitForNextPage(String previousTitle, String previousURL){

        navigationWait.until(ExpectedConditions.not(
                ExpectedConditions.and(
                        ExpectedConditions.titleIs(previousTitle),
                        ExpectedConditions.urlContains(previousURL)
                )
        ));
    }

    public Page getPage(String hyperlinkName){
        List<Page> allPages = allPages();
        String pageHyperlinkName;

        for (Page page : allPages) {
            pageHyperlinkName = page.getHyperlinkName();

            if(hyperlinkName.equals(pageHyperlinkName)){
                return page;
            }
        }

        Assert.assertTrue(false,"Wrong hyperlink name: " + hyperlinkName);
        return new HomePage(driver);
    }

    public void checkAddressAndTitle(Page page){
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, page.getPageUrl(), "Page address is different than expected");
        System.out.println(page.getPageUrl() + " page url ok");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , page.getPageTitle(), "Page title is different than expected");
        System.out.println(page.getPageTitle() + " page title ok");

        System.out.println();
    }

    public void backToMainPage(WebElement navigationBarImage){

        navigationBarImage.click();
        waitForHomePage();

        System.out.println("You back to main page");
    }

    public int getAmountOfNavigationElements(){
        return amountOfNavigationElements;
    }

    private int getActualAmountOfNavigationElements() {
        int actual = topNavigationMenu
                .size();
        return actual;
    }

    private List<Page> allPages(){
        List<Page> allPages = new ArrayList<>(getActualAmountOfNavigationElements());

        allPages.add(new HomePage(driver));
        allPages.add(new HotelsPage(driver));
        allPages.add(new FlightsPage(driver));
        allPages.add(new ToursPage(driver));
        allPages.add(new CarsPage(driver));
        allPages.add(new VisaPage(driver));
        allPages.add(new OffesrsPage(driver));
        allPages.add(new BlogPage(driver));

        return allPages;
    }

    private void waitForHomePage(){
        Page homePage = new HomePage(driver);

        System.out.println(homePage.getPageTitle());
        System.out.println(homePage.getPageUrl());

        navigationWait.until(ExpectedConditions.and(
                ExpectedConditions.titleIs(homePage.getPageTitle()),
                ExpectedConditions.urlContains(homePage.getPageUrl())
        ));
    }
}
