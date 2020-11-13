package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    protected By rootElement = By.cssSelector("div#navbar-brand-centered");
    protected By loginForm = By.cssSelector("form[name='frmLogin']");
    protected By newTourButton = By.cssSelector("a[href*='newtours']");
    protected By agileProjectButton = By.cssSelector("a[href*='Agile']");
    protected By seleniumDropDown = By.cssSelector("a.dropdown-toggle");
    protected By tableDemoLink = By.cssSelector("a[href*='table']");

    public HomePage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public void navigateToHomePage() {
        appiumDriver.get("http://demo.guru99.com/");
    }

    public boolean isLoginFormPresent() {
        return appiumDriver.findElement(loginForm).isDisplayed();
    }

    public void clickOnNewTourButton() {
        appiumDriver.findElement(rootElement).findElement(newTourButton).click();
    }

    public void clickOnAgileProjectButton() {
        appiumDriver.findElement(rootElement).findElement(agileProjectButton).click();
    }

    public void clickOnSeleniumDropDown() {
        appiumDriver.findElement(rootElement).findElement(seleniumDropDown).click();
    }

    public void clickOnTableDemoLink() {
        appiumDriver.findElement(rootElement).findElement(tableDemoLink).click();
    }
}
