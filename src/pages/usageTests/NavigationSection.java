package pages.usageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonPageElements;
import pages.Page;
import pages.allPages.*;

import java.util.List;

public class NavigationSection {
    WebDriver driver;
    CommonPageElements commonPageElements;
    int amountOfNavigationElements = 8;
    List<WebElement> topNavigationMenu;

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

    private Page getPage (String hyperlinkName) {
       Page page;

            switch (hyperlinkName) {
                case "Home":
                    page = new HomePage();
                    break;
                case "Hotels":
                    page = new HotelsPage();
                    break;
                case "Flights":
                    page = new FlightsPage();
                    break;
                case "Tours":
                    page = new ToursPage();
                    break;
                case "Cars":
                    page = new CarsPage();
                    break;
                case "Visa":
                    page = new VisaPage();
                    break;
                case "Offers":
                    page = new OffesrsPage();
                    break;
                case "Blog":
                    page = new BlogPage();
                    break;
                default:
                    page = new HotelsPage();
                    Assert.assertTrue(false,"Wrong hyperlink name: " + hyperlinkName);
            }
        return page;
    }

    private void checkAddressAndTitle(Page page){
        String actualPageAddress = driver.getCurrentUrl();
        Assert.assertEquals(actualPageAddress, page.getPageUrl(), "Page address is different than expected");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , page.getPageTitle(), "Page title is different than expected");
    }

    private int getActualAmountOfNavigationElements() {
        topNavigationMenu = commonPageElements.getTopNavigationMenu();
        int actual = topNavigationMenu
                .size();
        return actual;
    }
}
