package pages.allPages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class BlogPage extends Page {
    private String title = "Blog";
    private String pageUrl = "https://www.phptravels.net/blog";
    private String hyperlinkName = "blog";

    public BlogPage(WebDriver driver){
        super(driver);
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
