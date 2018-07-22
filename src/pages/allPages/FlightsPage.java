package pages.allPages;

import org.openqa.selenium.WebDriver;

public class FlightsPage {
    String title = "Flights List";
    String pageUrl = "https://www.phptravels.net/flights/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
