package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class CommonMethods {

    private WebDriver driver;
    private Duration pauseAfterAction;
    private Actions builder;
    private Action mouseOverWebElement;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.builder = new Actions(driver);
    }

    public String getTextFromWebElement(WebElement element) {
        String text = element.getText()
                .trim()
                .toLowerCase();

        return text;
    }

    public void mouseOverWebElement(WebElement element, int pause) {

        pauseAfterAction = Duration.ofSeconds(pause);

        mouseOverWebElement = builder.moveToElement(element)
                .pause(pauseAfterAction)
                .build();
        mouseOverWebElement.perform();
    }

    public void mouseOverWebElementAndClick(WebElement element, Duration pause) {

        mouseOverWebElement = builder.moveToElement(element)
                .pause(pause)
                .click()
                .build();
        mouseOverWebElement.perform();
    }

    public void waitForVisibilityOfWebElement(WebElement element, Duration timeout, Duration poolingTime){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(poolingTime);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibilityOfWebElement(WebElement element, Duration timeout, Duration poolingTime){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(poolingTime);

        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
