package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screens.dashboard.MainScreen;

public class PageObjectManager  {

    private AppiumDriver<MobileElement> appiumDriver;
    private MainScreen mainScreen;

    public PageObjectManager(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MainScreen getMainScreen(){
        return (mainScreen == null) ? mainScreen = new MainScreen(appiumDriver) : mainScreen;
    }

}
