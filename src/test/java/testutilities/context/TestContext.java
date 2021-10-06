package testutilities.context;

import lombok.Getter;
import lombok.Setter;
import screens.PageObjectManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import stepDefinitions.TestRunner;
import utilities.config.Configuration;
import utilities.config.ConfigurationManager;

public class TestContext {

    @Getter @Setter
    private AppiumDriver<MobileElement> appiumDriver;

    @Getter
    private ScenarioContext scenarioContext;

    @Getter
    private PageObjectManager pageObjectManager;

    @Getter
    private Configuration configuration = ConfigurationManager.getConfiguration();

    public TestContext() {
        setAppiumDriver(TestRunner.appiumDriver);
        pageObjectManager = new PageObjectManager(getAppiumDriver());
        scenarioContext = new ScenarioContext();
    }
}
