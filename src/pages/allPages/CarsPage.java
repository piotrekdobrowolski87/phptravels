package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class CarsPage extends Page {

    public CarsPage(WebDriver driver){
        super(driver);
        setTitle("Cars Listings");
        setPageUrl("https://www.phptravels.net/cars");
        setHyperlinkName("cars");
    }
}
