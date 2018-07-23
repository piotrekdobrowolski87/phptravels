package pages.allPages;

import pages.Page;

public class FlightsPage extends Page {
    private String title = "Flights List";
    private String pageUrl = "https://www.phptravels.net/flights/";
    private String hyperlinkName = "Flights";

    public FlightsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
