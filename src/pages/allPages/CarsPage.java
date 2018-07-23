package pages.allPages;

import pages.Page;

public class CarsPage extends Page {
    String title = "Cars Listings";
    String pageUrl = "https://www.phptravels.net/cars/";

    public CarsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
