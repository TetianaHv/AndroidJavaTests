import app.CalculatorMainView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class NativeAppTest {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");

        //127.0.0.1
        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        //start
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void testCalculator() {
        WebElement two = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_2')]"));
        two.click();
        WebElement plus = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'op_add')]"));
        plus.click();
        WebElement three = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_3')]"));
        three.click();
        WebElement equalTo = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'eq')]"));
        equalTo.click();
        WebElement result = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id, 'result')]"));

        assertEquals("5", result.getText(), "Actual value is:" + result.getText() + "did not match with expected value: 5");
    }

    @Test
    public void simpleSumTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit2().click();
        calculatorMainView.getPlusButton().click();
        calculatorMainView.getDigit3().click();
        calculatorMainView.getEqualButton().click();

        assertEquals("5", calculatorMainView.getResultField().getText());
        calculatorMainView.getClearButton().click();
    }

    @Test
    public void simpleMultiplicationTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit2().click();
        calculatorMainView.getPoint().click();
        calculatorMainView.getDigit2().click();
        calculatorMainView.getMultiplyButton().click();
        calculatorMainView.getDigit3().click();
        calculatorMainView.getEqualButton().click();

        assertEquals("6.6", calculatorMainView.getResultField().getText());
        calculatorMainView.getClearButton().click();
    }

    @Test
    public void simplePercentageOfNumberTest1() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit2().click();
        calculatorMainView.getDigit0().click();
        calculatorMainView.rotateLandscape(appiumDriver).getPercentButton().click();
        calculatorMainView.rotatePortrait(appiumDriver).getArrow().click();
        calculatorMainView.getEqualButton().click();

        assertEquals("0.2", calculatorMainView.getResultField().getText());
        calculatorMainView.getClearButton().click();
    }

    @Test
    public void simplePercentageOfNumberTest2() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

        calculatorMainView.getDigit1().click();
        calculatorMainView.getDigit0().click();
        calculatorMainView.rotateLandscape(appiumDriver).getPercentButton().click();
        calculatorMainView.rotatePortrait(appiumDriver).getArrow().click();
        calculatorMainView.getMultiplyButton().click();
        calculatorMainView.getDigit1().click();
        calculatorMainView.getDigit0().click();
        calculatorMainView.getEqualButton().click();

        assertEquals("1", calculatorMainView.getResultField().getText());
        calculatorMainView.getClearButton().click();
    }

    @AfterClass
    public void teardown() {
        appiumDriver.quit();
    }
}
