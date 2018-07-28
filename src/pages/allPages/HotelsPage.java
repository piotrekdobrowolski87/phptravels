package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class HotelsPage extends Page {
    private String title = "Search Results";
    private String pageUrl = "https://www.phptravels.net/hotels";
    private String hyperlinkName = "hotelss";

    public HotelsPage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
