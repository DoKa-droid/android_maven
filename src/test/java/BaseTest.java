import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    AppiumDriver driver;

    @BeforeEach
    public void setupClass() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("appPackage", "com.asos.app");
        capabilities.setCapability("app", "C:\\Users\\Kate-\\Downloads\\com.asos.app_4.64.0-12710_minAPI21(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi).apk");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appWaitForLaunch", false);
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
