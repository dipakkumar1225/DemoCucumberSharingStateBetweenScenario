package screens.dashboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainScreen extends BaseScreen {

    public MainScreen(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chapter 1: App Fundamentals')]")
    private MobileElement mobileElementElvChapter1;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Basic TextView')]")
    private List<MobileElement> mobileElementElvChapter1Content;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chapter 2: User Interface')]")
    private MobileElement mobileElementElvChapter2;

    public void selectChapter1() {
        mobileElementElvChapter1.click();
    }

    public boolean isChapter1ContentDisplayed() {
        getBaseMobileDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return mobileElementElvChapter1Content.size() > 0;
    }

    public void selectChapter2() {
        getWebDriverWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(mobileElementElvChapter2))).click();
    }
}
