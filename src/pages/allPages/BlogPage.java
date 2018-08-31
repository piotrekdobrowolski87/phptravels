package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class BlogPage extends Page {

    public BlogPage(WebDriver driver){
        super(driver);
        setTitle("Blog");
        setPageUrl("https://www.phptravels.net/blog");
        setHyperlinkName("blog");
    }
}
