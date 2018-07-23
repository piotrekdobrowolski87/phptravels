package pages.allPages;

import pages.Page;

public class ToursPage extends Page {
    String title = "Tours Listings";
    String pageUrl = "https://www.phptravels.net/tours/";

    public ToursPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
