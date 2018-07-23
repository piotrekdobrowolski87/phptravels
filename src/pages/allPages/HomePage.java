package pages.allPages;

import pages.Page;

public class HomePage extends Page {
    String title = "PHPTRAVELS | Travel Technology Partner";
    String pageUrl = "https://www.phptravels.net/";

    public HomePage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }

}
