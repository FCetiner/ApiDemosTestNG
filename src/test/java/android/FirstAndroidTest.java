package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {
    AppiumDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","7.0");
        caps.setCapability("deviceName","Pixel_2");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos.apk");

        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }
    @Test
    public void clickAppButton(){
        driver.findElementByAccessibilityId("App").click();
    }

    @AfterClass
    public void tearDown(){
        if (null != driver) {
            driver.quit();
        }
    }
}
