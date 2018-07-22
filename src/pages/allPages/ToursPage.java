package pages.allPages;

import org.openqa.selenium.WebDriver;

public class ToursPage {
    String title = "Tours Listings";
    String pageUrl = "https://www.phptravels.net/tours/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
