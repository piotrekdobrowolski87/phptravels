package pages.allPages;

import org.openqa.selenium.WebDriver;

public class VisaPage {
    String title = "Visa";
    String pageUrl = "https://www.phptravels.net/ivisa/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
