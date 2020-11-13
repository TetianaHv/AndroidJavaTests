package ui;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDropPage extends BasePage {
    protected By debitAccountDropField = By.xpath("//h3[@class='ui-widget-header' and contains(text(), 'DEBIT')]//..//h3[contains(text(), 'Account')]//../div");
    protected By debitAmountDropField = By.xpath("//h3[@class='ui-widget-header' and contains(text(), 'DEBIT')]//..//h3[contains(text(), 'Amount')]//../div");
    protected By creditAccountDropField = By.xpath("//h3[@class='ui-widget-header' and contains(text(), 'CREDIT')]//..//h3[contains(text(), 'Account')]//../div");
    protected By creditAmountDropField = By.xpath("//h3[@class='ui-widget-header' and contains(text(), 'CREDIT')]//..//h3[contains(text(), 'Amount')]//../div");
    protected By resultTable = By.cssSelector("div.table4_result");
    protected By dragAndDropForm = By.cssSelector("div.platform-content");

    protected Actions actionsSelenium;
    protected TouchAction actionAppium;

    public DragAndDropPage(AppiumDriver driver) {
        appiumDriver = driver;
        actionAppium = new TouchAction(driver);
    }

    public void navigate() {
        appiumDriver.get("http://demo.guru99.com/test/drag_drop.html");
    }

    public void putDebitAccount(String account) {
        WebElement from = appiumDriver.findElement(By.xpath("//a[@class='button button-orange' and contains(text(),'" + account + "')]"));
        WebElement to = appiumDriver.findElement(debitAccountDropField);
        dragAndDrop(from, to);
    }

    public void putDebitAmount(String amount) {
        WebElement from = appiumDriver.findElement(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + amount + "')]"));
        WebElement to = appiumDriver.findElement(debitAmountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAccount(String account) {
        WebElement from = appiumDriver.findElement(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = appiumDriver.findElement(creditAccountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAmount(String amount) {
        WebElement from = appiumDriver.findElement(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + amount + "')]"));
        WebElement to = appiumDriver.findElement(creditAmountDropField);
        dragAndDrop(from, to);
    }

    protected void dragAndDrop(WebElement from, WebElement to) {
        actionAppium.longPress(PointOption.point(from.getLocation().getX(), from.getLocation().getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(to.getLocation().getX(), from.getLocation().getY()))
                .release()
                .perform();
    }

    public boolean successMessageIsShown() {
        return appiumDriver.findElement(resultTable).isDisplayed();
    }


//    @FindBy(xpath = "//h3[contains(text(), 'DEBIT')]/..//h3[contains(text(), 'Account')]/..//li")
//    protected SelenideElement debitAccountDropField;
//    @FindBy(xpath = "//h3[contains(text(), 'DEBIT')]/..//h3[contains(text(), 'Amount')]/..//li")
//    protected SelenideElement debitAmountDropField;
//    @FindBy(xpath = "//h3[contains(text(), 'CREDIT')]/..//h3[contains(text(), 'Account')]/..//li")
//    protected SelenideElement creditAccountDropField;
//    @FindBy(xpath = "//h3[contains(text(), 'CREDIT')]/..//h3[contains(text(), 'Amount')]/..//li")
//    protected SelenideElement creditAmountDropField;
//    @FindBy(css = "div.table4_result")
//    protected SelenideElement resultTable;
//    @FindBy(css = "div.platform-content")
//    protected SelenideElement dragAndDropForm;
//
//    protected Actions actionsSelenium;
//    protected TouchAction actionAppium;
//
//    public DragAndDropPage(AppiumDriver driver) {
//        appiumDriver = driver;
//        actionAppium = new TouchAction(driver);
//        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
//    }
//
//    public void navigate() {
//        appiumDriver.get("http://demo.guru99.com/test/drag_drop.html");
//    }
//
//    public void putDebitAccount(String account) {
//        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
//        WebElement to = debitAccountDropField;
//        dragAndDrop(from, to);
//    }
//
//    public void putDebitAmount(String amount) {
//        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + amount + "')]"));
//        WebElement to = debitAmountDropField;
//        dragAndDrop(from, to);
//    }
//
//    public void putCreditAccount(String account) {
//        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
//        WebElement to = creditAccountDropField;
//        dragAndDrop(from, to);
//    }
//
//    public void putCreditAmount(String amount) {
//        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + amount + "')]"));
//        WebElement to = creditAmountDropField;
//        dragAndDrop(from, to);
//    }
//
//    protected void dragAndDrop(WebElement from, WebElement to) {
//        actionAppium.longPress(PointOption.point(from.getLocation().getX(), from.getLocation().getY()))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//                .moveTo(PointOption.point(to.getLocation().getX(), to.getLocation().getY()))
//                .perform()
//                .release();
//    }
//
//    public boolean successMessageIsShown() {
//        return resultTable.isDisplayed();
//    }
}
