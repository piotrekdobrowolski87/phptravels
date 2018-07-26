package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class HomePage extends Page {
    private String title = "PHPTRAVELS | Travel Technology Partner";
    private String pageUrl = "https://www.phptravels.net/";
    private String hyperlinkName = "Home";

    public HomePage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }

}
