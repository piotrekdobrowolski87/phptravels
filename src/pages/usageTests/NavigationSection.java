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

    public Page getPage (String hyperlinkName) {
       Page page;

            switch (hyperlinkName) {
                case "home":
                    page = new HomePage(driver);
                    break;
                case "hotels":
                    page = new HotelsPage(driver);
                    break;
                case "flights":
                    page = new FlightsPage(driver);
                    break;
                case "tours":
                    page = new ToursPage(driver);
                    break;
                case "cars":
                    page = new CarsPage(driver);
                    break;
                case "visa":
                    page = new VisaPage(driver);
                    break;
                case "offers":
                    page = new OffesrsPage(driver);
                    break;
                case "blog":
                    page = new BlogPage(driver);
                    break;

                default:
                    page = new HotelsPage(driver);
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
