package pages;

public class Page {
    String pageUrl = "*";
    String title = "*";

    protected Page(){
    }


    public String getPageUrl() {
        return this.pageUrl;
    }

    public String getPageTitle(){
        return this.title;
    }

    protected void setPageUrl(String pageUrl){
        this.pageUrl = pageUrl;
    }

    protected void setTitle(String title){
        this.title = title;
    }
}
