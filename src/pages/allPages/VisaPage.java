package pages.allPages;

import pages.Page;

public class VisaPage extends Page {
    private String title = "Visa";
    private String pageUrl = "https://www.phptravels.net/ivisa/";
    private String hyperlinkName = "Visa";

    public VisaPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
