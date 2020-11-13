package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BasePage {
    protected AppiumDriver appiumDriver;

    protected By title = By.tagName("title");

    public String getTitle(AppiumDriver app) {
        return app.findElement(title).getAttribute("text");
    }
}
