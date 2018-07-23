package pages.allPages;

import pages.Page;

public class OffesrsPage extends Page {
    String title = "Special Offers";
    String pageUrl = "https://www.phptravels.net/offers/";

    public OffesrsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
