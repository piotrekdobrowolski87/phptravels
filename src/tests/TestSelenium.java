package tests;

import common.BrowserSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import common.Data;

public class TestSelenium {

    WebDriver driver;
    Data data = new Data();

    @BeforeSuite
    @Parameters("browser")
    public void dupa(String browser){
        //this.driver = new ChromeDriver();

        BrowserSelection browserSelection = new BrowserSelection();
        this.driver = browserSelection.setBrowser(browser);

        driver.manage()
                .window()
                .setSize(data.getDimension());
        driver.get(data.getPageAddress());
    }

    @AfterTest
    public void returnToMainPage(){
        System.out.println("AfterTest");
    }

    @Test
    public void pageAddressVerify(){
        Assert.assertEquals(driver.getCurrentUrl() + "a", data.getPageAddress(), "Wrong page address");
    }

    @Test
    public void pageAddressVerify2(){
        Assert.assertEquals(driver.getCurrentUrl(), data.getPageAddress(), "Wrong page address");
    }

    @AfterSuite
    public void end(){
        driver.quit();
    }
}
