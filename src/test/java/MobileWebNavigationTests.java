import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.HomePage;
import ui.NewToursPage;
import ui.TablePage;

import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MobileWebNavigationTests {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        //start
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void navigateToHomePageTest() throws InterruptedException {
        HomePage homePage = new HomePage(appiumDriver);
        //    When user navigate to homePage
        homePage.navigateToHomePage();
//        Thread.sleep(2000);
        //    Then title of homePage is "Guru99 Bank Home Page"
        assertEquals(homePage.getTitle(appiumDriver), " Guru99 Bank Home Page ");
        //    And login form is present
        assertTrue(homePage.isLoginFormPresent());
    }

    @Test
    public void navigateToNewToursPageTest() throws InterruptedException {
        HomePage homePage = new HomePage(appiumDriver);
        NewToursPage newToursPage = new NewToursPage(appiumDriver);
        //    Given user is on home page
        homePage.navigateToHomePage();
//        Thread.sleep(2000);
        assertTrue(homePage.isLoginFormPresent());
        //    When user click on newToursButton
        homePage.clickOnNewTourButton();
        //    Then title of newToursPage is "Welcome: Mercury Tours"
        assertEquals(newToursPage.getTitle(appiumDriver), "Welcome: Mercury Tours");
        //    And main fragment is present
        assertTrue(newToursPage.isMainFragmentPresent(appiumDriver));
    }

    @Test
    public void navigateToTablePageTest() throws InterruptedException {
        HomePage homePage = new HomePage(appiumDriver);
        TablePage tablePage = new TablePage(appiumDriver);
        //    Given user is on home page
        homePage.navigateToHomePage();
//        Thread.sleep(2000);
        assertTrue(homePage.isLoginFormPresent());
        //    When user click on tableDemoLink
        homePage.clickOnSeleniumDropDown();
        homePage.clickOnTableDemoLink();
        //    Then title of tablePage is "Table Demo"
        assertEquals(tablePage.getTitle(appiumDriver), "Table Demo");
        //    And table is present
        assertTrue(tablePage.isTablePresent(appiumDriver));
    }


//    @Test
//    public void test4() {
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
