package pages.allPages;

import pages.Page;

public class HotelsPage extends Page {
    private String title = "Search Results";
    private String pageUrl = "https://www.phptravels.net/hotels/";
    private String hyperlinkName = "Hotels";

    public HotelsPage(){
        super();
        setTitle(this.title);
        setPageUrl(this.pageUrl);
        setHyperlinkName(this.hyperlinkName);
    }
}
