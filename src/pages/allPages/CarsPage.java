package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class CarsPage extends Page {
    private String title = "Cars Listings";
    private String pageUrl = "https://www.phptravels.net/cars";
    private String hyperlinkName = "Cars";

    public CarsPage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
