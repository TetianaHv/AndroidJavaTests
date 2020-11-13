package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NewToursPage extends BasePage {
    protected By rootElement = By.xpath("div.row>nav");

    public NewToursPage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public boolean isMainFragmentPresent(AppiumDriver appiumDriver) {
        return appiumDriver.findElement(rootElement).isDisplayed();
    }

}
