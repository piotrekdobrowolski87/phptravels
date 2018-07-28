package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class ToursPage extends Page {
    private String title = "Tours Listings";
    private String pageUrl = "https://www.phptravels.net/tours";
    private String hyperlinkName = "tours";

    public ToursPage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
