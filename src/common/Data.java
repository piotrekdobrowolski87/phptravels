package common;

import org.openqa.selenium.Dimension;

public class Data {
    private Dimension dimension = new Dimension(1600, 900);
    private String pageAddress = "https://www.phptravels.net/";
    private String login = "";
    private String password = "";

    public String getPageAddress() {
        return pageAddress;
    }

    public Dimension getDimension(){
        return dimension;
    }

}
