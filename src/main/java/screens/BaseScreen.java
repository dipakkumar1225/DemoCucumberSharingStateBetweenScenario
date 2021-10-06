package screens;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class BaseScreen {

    @Getter(AccessLevel.PROTECTED)
    private AppiumDriver<MobileElement> baseMobileDriver;

    @Getter(AccessLevel.PROTECTED)
    private WebDriverWait webDriverWait;

    protected BaseScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.baseMobileDriver = appiumDriver;
        AppiumFieldDecorator appiumFieldDecorator = new AppiumFieldDecorator(this.baseMobileDriver, ofSeconds(60));
        PageFactory.initElements(appiumFieldDecorator, this);
        webDriverWait = new WebDriverWait(getBaseMobileDriver(), 20);
    }
}
