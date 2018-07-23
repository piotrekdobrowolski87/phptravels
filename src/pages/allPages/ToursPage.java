package pages.allPages;

import pages.Page;

public class ToursPage extends Page {
    private String title = "Tours Listings";
    private String pageUrl = "https://www.phptravels.net/tours/";
    private String hyperlinkName = "Tours";

    public ToursPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
