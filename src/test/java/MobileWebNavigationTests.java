import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.DragAndDropPage;
import ui.HomePage;

import javax.annotation.concurrent.Immutable;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.testng.Assert.assertTrue;

public class MobileWebTest {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        //start
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void test1() {
        HomePage homePage = new HomePage(appiumDriver);
        homePage.navigate();
    }





//    @Test
//    public void test2() {
//        DragAndDropPage dragAndDropPage = new DragAndDropPage(appiumDriver);
//        dragAndDropPage.navigate();
//        dragAndDropPage.putDebitAccount("BANK");
//        dragAndDropPage.putDebitAmount("5000");
//        dragAndDropPage.putCreditAccount("SALES");
//        dragAndDropPage.putCreditAmount("5000");
//
//        assertTrue(dragAndDropPage.successMessageIsShown());
//    }

    @AfterClass
    public void teardown() {
        appiumDriver.quit();
    }
}
