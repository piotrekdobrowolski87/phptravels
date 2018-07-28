package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class FlightsPage extends Page {
    private String title = "Flights List";
    private String pageUrl = "https://www.phptravels.net/flights";
    private String hyperlinkName = "fslights";

    public FlightsPage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
