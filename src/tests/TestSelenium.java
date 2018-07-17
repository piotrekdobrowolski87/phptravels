package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import common.Data;

public class TestSelenium {

    WebDriver driver;
    Data data = new Data();

    @BeforeClass
    public void dupa(){
        this.driver = new ChromeDriver();
        driver.manage()
                .window()
                .setSize(data.getDimension());
        driver.get(data.getPageAddress());
    }

    @AfterMethod
    public void returnToMainPage(){
        System.out.println("Dupa");
    }

    @Test
    public void pageAddressVerify(){
        Assert.assertEquals(driver.getCurrentUrl() + "a", data.getPageAddress(), "Wrong page address");
    }

    @Test
    public void pageAddressVerify2(){
        Assert.assertEquals(driver.getCurrentUrl(), data.getPageAddress(), "Wrong page address");
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
