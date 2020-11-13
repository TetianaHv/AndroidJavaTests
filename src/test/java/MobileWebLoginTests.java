import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.AgileProjectPage;
import ui.HomePage;

import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.testng.Assert.*;

public class MobileWebLoginTests {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        //start
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void positiveLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(appiumDriver);
        AgileProjectPage agileProjectPage = new AgileProjectPage(appiumDriver);
        //    Given user is on home page
        homePage.navigateToHomePage();
        assertTrue(homePage.isLoginFormPresent());
        //    When user navigates to agile page
        homePage.clickOnAgileProjectButton();
        //    And user enters username "1303" and password "Guru99" And click login button
        agileProjectPage.enterLoginAndPasswordAndClickEnter("1303", "Guru99");
        //    Then welcome message is "Welcome To Customer's Page of Guru99 Bank"
//        Thread.sleep(2000);
        assertEquals(agileProjectPage.getWelcomeMessage(), "Welcome To Customer's Page of Guru99 Bank");
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(appiumDriver);
        AgileProjectPage agileProjectPage = new AgileProjectPage(appiumDriver);
        //    Given user is on home page
        homePage.navigateToHomePage();
        assertTrue(homePage.isLoginFormPresent());
        //    When user navigates to agile page
        homePage.clickOnAgileProjectButton();
        //    And user enters username "1303" and password "Guru99" And click login button
        agileProjectPage.enterLoginAndPasswordAndClickEnter("111", "xyz");
        //    Then welcome message is "Welcome To Customer's Page of Guru99 Bank"
//        Thread.sleep(2000);
        assertEquals(agileProjectPage.getInvalidCredentialsMessage(), "User or Password is not valid");
        agileProjectPage.closeAlert();
    }

    @AfterClass
    public void teardown() {
        appiumDriver.quit();
    }
}
