package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstAndroidTestBrowserStack {
    AppiumDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        String userName = "ahmetcankaya_pTg908";
        String accessKey = "43psXsLLFxSq4AU5erz8";
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Samsung Galaxy S21");
        caps.setCapability("app","bs://8af81386e6d3234e886da4a4fe82445ab1885131");


        driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
