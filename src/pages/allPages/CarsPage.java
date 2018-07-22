package pages.allPages;

import org.openqa.selenium.WebDriver;

public class CarsPage {
    String title = "Cars Listings";
    String pageUrl = "https://www.phptravels.net/cars/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
