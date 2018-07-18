package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSelection {

    private WebDriver driver;

    public WebDriver setBrowser(String browser){
        switch (browser) {
            case "Chrome":
                this.driver = new ChromeDriver();
                break;
            case "Firefox":
                this.driver = new ChromeDriver();
                break;
            case "Edge":
                this.driver = new ChromeDriver();
                break;

                default:
                    this.driver = new ChromeDriver();
        }
        return driver;
    }
}
