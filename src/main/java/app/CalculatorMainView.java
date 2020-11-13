package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;

public class CalculatorMainView {
    AppiumDriver appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_0')]")
    public MobileElement digit0;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_1')]")
    public MobileElement digit1;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_2')]")
    public MobileElement digit2;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_3')]")
    public MobileElement digit3;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_add')]")
    public MobileElement plusButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_mul')]")
    public MobileElement multiplyButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'eq')]")
    public MobileElement equalButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_pct')]")
    public MobileElement percentButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'result')]")
    public MobileElement resultField;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'dec_p')]")
    public MobileElement point;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'clr')]")
    public MobileElement clearButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id, 'arrow')]")
    public MobileElement arrow;

    public CalculatorMainView(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public MobileElement getDigit0() {
        return digit0;
    }

    public MobileElement getDigit1() {
        return digit1;
    }

    public MobileElement getDigit2() {
        return digit2;
    }

    public MobileElement getDigit3() {
        return digit3;
    }

    public MobileElement getPlusButton() {
        return plusButton;
    }

    public MobileElement getEqualButton() {
        return equalButton;
    }

    public MobileElement getResultField() {
        return resultField;
    }

    public MobileElement getMultiplyButton() {
        return multiplyButton;
    }

    public MobileElement getArrow() {
        return arrow;
    }

    public MobileElement getPoint() {
        return point;
    }

    public MobileElement getPercentButton() {
        return percentButton;
    }

    public MobileElement getClearButton() {
        return clearButton;
    }

    public CalculatorMainView rotateLandscape(AppiumDriver appiumDriver) {
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
        return this;
    }

    public CalculatorMainView rotatePortrait(AppiumDriver appiumDriver) {
        appiumDriver.rotate(ScreenOrientation.PORTRAIT);
        return this;
    }
}
