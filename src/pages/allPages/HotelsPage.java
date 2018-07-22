package pages.allPages;

import org.openqa.selenium.WebDriver;

public class HotelsPage {
    String title = "Search Results";
    String pageUrl = "https://www.phptravels.net/hotels/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
