package tests;

import common.SetBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Home {

    WebDriver driver;

    @BeforeTest (alwaysRun = true)
    @Parameters ({"browser", "width", "height", "pageAddress"})
public void setUpBrowser(String browser, int width, int height, String pageAddress){
        SetBrowser setBrowser = new SetBrowser();

        this.driver = setBrowser.setBrowser(browser,width,height,pageAddress);

}

@Test
public void test(){
}

@AfterSuite (alwaysRun = true)
public void end(){
        driver.quit();
}
}
