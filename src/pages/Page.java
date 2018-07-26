package pages;

import org.openqa.selenium.WebDriver;

public class Page {
    private String pageUrl = "";
    private String title = "";
    private String hyperlinkName = "";

    protected Page(WebDriver driver){
    }


    public String getPageUrl() {
        return this.pageUrl;
    }

    public String getPageTitle(){
        return this.title;
    }

    public String getHyperlinkName(){
        return this.hyperlinkName;
    }

    protected void setPageUrl(String pageUrl){
        this.pageUrl = pageUrl;
    }

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setHyperlinkName(String hyperlinkName){
        this.hyperlinkName = hyperlinkName;
    }
}
