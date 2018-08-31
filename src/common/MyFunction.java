package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

public class MyFunction implements Function<WebDriver, WebElement> {

    WebElement webElement;

    @Override
    public WebElement apply(WebDriver driver) {
        System.out.println("wait for bar");
        return webElement;
    }

    public void setWebElement(WebElement webElement){
        this.webElement = webElement;
    }
}