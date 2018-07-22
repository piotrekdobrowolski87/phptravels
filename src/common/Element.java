package common;

import org.openqa.selenium.WebElement;

public class Element {

    private WebElement webElement;
    private String name;

    public Element(String name, WebElement webElement){
        this.webElement = webElement;
        this.name = name;
        System.out.println(this.name + " created");
    }

    public void cickElement(){
        webElement.click();
        System.out.println("Click on " + name);
    }

    public WebElement getWebElement(){
        return webElement;
    }
}
