package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.testng.annotations.*;
import testutilities.context.TestContext;
import utilities.enums.DeviceTypeEnum;
import utilities.platform.DriverFactory;
import utilities.platform.DriverManager;
import utilities.config.Configuration;
import utilities.config.ConfigurationManager;

@CucumberOptions(
        monochrome = true,
        glue = "stepDefinitions",
        tags = "@Demo",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"summary",
                "pretty",
                "html:target/cucumber-reports/advanced-reports.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/rerun.txt"
        },
        features = {
                "classpath:features/01_Permission.feature",
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Getter(AccessLevel.PROTECTED)
    private DriverManager mobileDriverManager;

    public static AppiumDriver<MobileElement> appiumDriver;
    Configuration configuration = ConfigurationManager.getConfiguration();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        mobileDriverManager = DriverFactory.getMobileDriverManager(DeviceTypeEnum.ANDROID);
        appiumDriver = mobileDriverManager.getMobileDriver(configuration.androidPlatformAndVersion(), configuration.androidDeviceUDID(), configuration.androidSystemPort(), AutomationName.ANDROID_UIAUTOMATOR2);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        getMobileDriverManager().quitAppiumDriver();
    }
}
