package pages.allPages;

import pages.Page;

public class VisaPage extends Page {
    String title = "Visa";
    String pageUrl = "https://www.phptravels.net/ivisa/";

    public VisaPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
