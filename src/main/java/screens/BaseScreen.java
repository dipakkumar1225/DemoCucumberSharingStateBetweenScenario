package screens;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {

    @Getter(AccessLevel.PROTECTED)
    private AppiumDriver<MobileElement> baseMobileDriver;

    @Getter(AccessLevel.PROTECTED)
    private WebDriverWait webDriverWait;

    protected BaseScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.baseMobileDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.baseMobileDriver), this);
        webDriverWait = new WebDriverWait(getBaseMobileDriver(), 30);
    }
}
