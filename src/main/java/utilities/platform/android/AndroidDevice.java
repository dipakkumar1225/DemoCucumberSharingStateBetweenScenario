package utilities.platform.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.platform.DriverManager;
import utilities.config.Configuration;
import utilities.config.ConfigurationManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDevice extends DriverManager {
    Configuration configuration = ConfigurationManager.getConfiguration();

    @Override
    protected void createDriver(String platform, String udid, String systemPort, String automationName) {

        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String[] platformInfo = platform.split(" ");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(AndroidMobileCapabilityType.DISABLE_WINDOW_ANIMATION,true);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.parseInt(systemPort));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        capabilities.setCapability(MobileCapabilityType.APP, new File(configuration.androidAppPath()).getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configuration.androidAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configuration.androidAppActivity());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("enableWebviewDetailsCollection",true);
        capabilities.setCapability(AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, configuration.noReset());
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);

        if (url != null) {
            mobileDriver = new AndroidDriver<>(url, capabilities);
        }
    }
}
