package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
        setTitle("PHPTRAVELS | Travel Technology Partner");
        setPageUrl("https://www.phptravels.net/");
        setHyperlinkName("home");
    }

}
