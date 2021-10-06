package utilities.platform;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.Objects;

public abstract class DriverManager {

    protected AppiumDriver<MobileElement> mobileDriver;

    protected abstract void createDriver(String platform, String udid, String systemPort, String automationName);

    public AppiumDriver<MobileElement> getMobileDriver(String platform, String udid, String systemPort, String automationName) {
        if (mobileDriver == null) {
            createDriver(platform, udid, systemPort, automationName);
        }
        return mobileDriver;
    }

    public void setMobileDriver(AppiumDriver<MobileElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
    }

    public AppiumDriver<MobileElement> getMobileDriver() {
        return mobileDriver;
    }

    public String deviceManufacturer() {
        return Objects.requireNonNull(mobileDriver.getCapabilities().getCapability("deviceManufacturer").toString());


    }

    public String deviceModel() {
        return Objects.requireNonNull(mobileDriver.getCapabilities().getCapability("deviceModel").toString());
    }

    public String deviceScreenSize() {
        return Objects.requireNonNull(mobileDriver.getCapabilities().getCapability("deviceScreenSize").toString());
    }

    public String platformName() {
        return Objects.requireNonNull(mobileDriver.getPlatformName());
    }

    public String platformVersion() {
        return Objects.requireNonNull(mobileDriver.getCapabilities().getCapability("platformVersion").toString());
    }

    public void quitAppiumDriver() {
        if (mobileDriver != null) {
            mobileDriver.closeApp();
            mobileDriver.quit();
            mobileDriver = null;
        }
    }
}
