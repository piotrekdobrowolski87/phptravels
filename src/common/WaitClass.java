package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitClass {

    public void waitForVisibility(WebElement webElement){
        ExpectedConditions.visibilityOf(webElement);
    }

}
