package pages.allPages;

import pages.Page;

public class CarsPage extends Page {
    private String title = "Cars Listings";
    private String pageUrl = "https://www.phptravels.net/cars/";
    private String hyperlinkName = "Cars";

    public CarsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
