package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class VisaPage extends Page {

    public VisaPage(WebDriver driver){
        super(driver);
        setTitle("Visa");
        setPageUrl("https://www.phptravels.net/ivisa");
        setHyperlinkName("visa");
    }
}
