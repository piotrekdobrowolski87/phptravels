package pages.allPages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    String title = "PHPTRAVELS | Travel Technology Partner";
    String pageUrl = "https://www.phptravels.net/";
    WebDriver driver;
    //CommonPageElements commonPageElements = new CommonPageElements();

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //public void checkAddresAndTitle(){
    //    commonPageElements.checkAddressAndTitle(pageUrl, homePageTitle, driver);
    //}

    public String getExpectedPageUrl(){
        return pageUrl;
    }

}
