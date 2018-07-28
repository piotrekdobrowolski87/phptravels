package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class VisaPage extends Page {
    private String title = "Visa";
    private String pageUrl = "https://www.phptravels.net/ivisa";
    private String hyperlinkName = "visa";

    public VisaPage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
