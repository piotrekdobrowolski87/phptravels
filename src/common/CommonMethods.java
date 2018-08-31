package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

    private WebDriver driver;


    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextFromWebElement(WebElement element) {
        String text = element.getText()
                .trim()
                .toLowerCase();

        return text;
    }
}
