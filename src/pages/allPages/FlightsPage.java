package pages.allPages;

import pages.Page;

public class FlightsPage extends Page {
    String title = "Flights List";
    String pageUrl = "https://www.phptravels.net/flights/";

    public FlightsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
