package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class OffesrsPage extends Page {

    public OffesrsPage(WebDriver driver){
        super(driver);
        setTitle("Special Offers");
        setPageUrl("https://www.phptravels.net/offers");
        setHyperlinkName("offers");
    }
}
