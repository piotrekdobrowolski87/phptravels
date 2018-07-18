package common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetBrowser {

    private WebDriver driver;

    public WebDriver setBrowser(String browser, int width, int height, String pageAddress){

        browserSelection(browser);
        setDimension(width,height);
        driver.get(pageAddress);

        return driver;
    }

    private void browserSelection(String browser){
        switch (browser) {
            case "Chrome":
                this.driver = new ChromeDriver();
                break;
            case "Firefox":
                this.driver = new FirefoxDriver();
                break;
            case "Edge":
                this.driver = new EdgeDriver();
                break;

            default:
                this.driver = new ChromeDriver();
        }
    }

    private void setDimension(int width, int height) {
        Dimension dimension = new Dimension(width,height);
        this.driver.manage()
                .window()
                .setSize(dimension);
    }
}
