package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AgileProjectPage extends BasePage {
    protected By login = By.name("uid");
    protected By password = By.name("password");
//    protected By loginButton = By.name("btnLogin");
    protected By welcomeMessage = By.className("heading3");

    public AgileProjectPage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public void enterLoginAndPasswordAndClickEnter(String log, String pass) {
        appiumDriver.findElement(login).sendKeys(log);
        appiumDriver.findElement(password).sendKeys(pass + Keys.ENTER);
    }

//    public void clickLoginButton() {
//        appiumDriver.findElement(loginButton).click();
//    }

    public String getWelcomeMessage() {
        return appiumDriver.findElement(welcomeMessage).getText();
    }

    public String getInvalidCredentialsMessage() {
        return appiumDriver.switchTo().alert().getText();
    }

    public void closeAlert() {
        appiumDriver.switchTo().alert().accept();
    }
}
