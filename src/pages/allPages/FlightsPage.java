package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class FlightsPage extends Page {

    public FlightsPage(WebDriver driver){
        super(driver);
        setTitle("Flights List");
        setPageUrl("https://www.phptravels.net/flights");
        setHyperlinkName("flights");
    }
}
