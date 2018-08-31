package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class ToursPage extends Page {

    public ToursPage(WebDriver driver){
        super(driver);
        setTitle("Tours Listings");
        setPageUrl("https://www.phptravels.net/tours");
        setHyperlinkName("tours");
    }
}
