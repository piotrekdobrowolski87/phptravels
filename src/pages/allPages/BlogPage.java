package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Pages;

public class BlogPage extends Pages {
    String title = "Blog";
    String pageUrl = "https://www.phptravels.net/blog/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public String getExpectedPageUrl(){
        return pageUrl;
    }
}
