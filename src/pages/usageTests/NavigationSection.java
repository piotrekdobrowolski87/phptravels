package pages.usageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonPageElements;
import pages.Page;
import pages.allPages.*;

import java.util.ArrayList;
import java.util.List;

public class NavigationSection {
    private WebDriver driver;
    private CommonPageElements commonPageElements;
    private int amountOfNavigationElements = 8;
    private List<WebElement> topNavigationMenu;

    public NavigationSection(WebDriver driver) {
        this.driver = driver;
        commonPageElements = new CommonPageElements(this.driver);
    }

    public boolean checkAmountOfNavigationElements() {
        boolean result = false;

        if (amountOfNavigationElements == getActualAmountOfNavigationElements()) {
            result = true;
        }

        return result;
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

    public void checkAddressAndTitle(Page page){
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, page.getPageUrl(), "Page address is different than expected");
        System.out.println(page.getPageTitle() + " page url ok");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , page.getPageTitle(), "Page title is different than expected");
        System.out.println(page.getPageTitle() + " page title ok");

        System.out.println();
    }

    public int getAmountOfNavigationElements(){
        return amountOfNavigationElements;
    }

    private int getActualAmountOfNavigationElements() {
        topNavigationMenu = commonPageElements.getTopNavigationMenu();
        int actual = topNavigationMenu
                .size();
        return actual;
    }
}
