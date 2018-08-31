package pages.allPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.CommonPageElements;
import pages.Page;

public class HomePage extends Page {

    @FindBy(how = How.CLASS_NAME, using = "right carousel-control visible-lg visible-md")
    private WebElement moveRight;

    //private CommonPageElements commonPageElements = new co

    public HomePage(WebDriver driver){
        super(driver);
        setTitle("PHPTRAVELS | Travel Technology Partner");
        setPageUrl("https://www.phptravels.net/");
        setHyperlinkName("home");

        PageFactory.initElements(getDriver(),this);
    }
}
