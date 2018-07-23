package pages.allPages;

import pages.Page;

public class HomePage extends Page {
    private String title = "PHPTRAVELS | Travel Technology Partner";
    private String pageUrl = "https://www.phptravels.net/";
    private String hyperlinkName = "Home";

    public HomePage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }

}
