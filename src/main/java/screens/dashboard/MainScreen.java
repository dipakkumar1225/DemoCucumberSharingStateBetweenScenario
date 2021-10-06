package screens.dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.BaseScreen;

public class MainScreen extends BaseScreen {

    public MainScreen(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chapter 1: App Fundamentals')]")
    private MobileElement mobileElementElvChapter1;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chapter 2: User Interface')]")
    private MobileElement mobileElementElvChapter2;

    public void selectChapter1() {
        mobileElementElvChapter1.click();
    }

    public void selectChapter2() {
        mobileElementElvChapter2.click();
    }
}
