package pages.allPages;

import pages.Page;

public class BlogPage extends Page {
    private String title = "Blog";
    private String pageUrl = "https://www.phptravels.net/blog/";

    public BlogPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
