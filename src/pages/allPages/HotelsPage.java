package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class HotelsPage extends Page {

    public HotelsPage(WebDriver driver){
        super(driver);
        setTitle("Search Results");
        setPageUrl("https://www.phptravels.net/hotels");
        setHyperlinkName("hotels");
    }
}
