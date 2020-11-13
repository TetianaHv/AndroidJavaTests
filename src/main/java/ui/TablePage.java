package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TablePage extends BasePage {
    private By table = By.tagName("table");

    public TablePage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public boolean isTablePresent(AppiumDriver appiumDriver) {
        return appiumDriver.findElement(table).isDisplayed();
    }
}
