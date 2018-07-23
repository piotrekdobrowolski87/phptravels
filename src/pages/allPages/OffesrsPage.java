package pages.allPages;

import pages.Page;

public class OffesrsPage extends Page {
    private String title = "Special Offers";
    private String pageUrl = "https://www.phptravels.net/offers/";
    private String hyperlinkName = "Offers";

    public OffesrsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
