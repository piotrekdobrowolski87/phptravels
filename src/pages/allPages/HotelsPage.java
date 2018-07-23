package pages.allPages;

import pages.Page;

public class HotelsPage extends Page {
    String title = "Search Results";
    String pageUrl = "https://www.phptravels.net/hotels/";

    public HotelsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
    }
}
