package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SwipeAndroidBrowserStack {

    public AppiumDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String userName = "ahmetcankaya_pTg908";
        String accessKey = "43psXsLLFxSq4AU5erz8";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Samsung Galaxy S21");
        caps.setCapability("app","bs://8af81386e6d3234e886da4a4fe82445ab1885131");
        driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void swipe_test() {
        AndroidElement views = (AndroidElement)
                driver.findElementByAccessibilityId("Views");

        //Tap
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();


        AndroidElement gallery = (AndroidElement)
                driver.findElementByAccessibilityId("Gallery");
        actions.tap(ElementOption.element(gallery)).perform();


        AndroidElement photo = (AndroidElement)
                driver.findElementByAccessibilityId("1. Photos");
        actions.tap(ElementOption.element(photo)).perform();

        AndroidElement pic1 =
                (AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);

        actions.press(ElementOption.element(pic1))
                .waitAction()
                .moveTo(PointOption.point(-20, 210))
                .release()
                .perform();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
