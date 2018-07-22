package pages.allPages;

import org.openqa.selenium.WebDriver;

public class OffesrsPage {
    String title = "Special Offers";
    String pageUrl = "https://www.phptravels.net/offers/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
