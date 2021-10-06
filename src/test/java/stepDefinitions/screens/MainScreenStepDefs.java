package stepDefinitions.screens;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import testutilities.context.ContextEnum;
import testutilities.context.TestContext;

public class MainScreenStepDefs {

    TestContext testContext;

    public MainScreenStepDefs(TestContext context) {
        this.testContext = context;
    }

    @Given("Check AUT is installed")
    public void checkAUTIsInstalled() {
        boolean abc = testContext.getAppiumDriver().isAppInstalled(testContext.getConfiguration().androidAppPackage());
        SoftAssertions.assertSoftly(softAssertions -> softAssertions.assertThat(abc).as("Application \"" +testContext.getConfiguration().androidAppPackage()+"\" is not installed.").isTrue());
        testContext.getScenarioContext().setContext(ContextEnum.DEMO, "demo");
    }

    @When("Click on chapter - Chapter 1: App Fundamentals")
    public void clickOnChapter1() {
        testContext.getPageObjectManager().getMainScreen().selectChapter1();
        String abc  = (String) testContext.getScenarioContext().getContext(ContextEnum.DEMO);
        System.out.println("Data :--------------- \t" + abc);
    }

    @When("Click on demo chapter - Chapter 2: User Interface")
    public void clickOnDemoChapter2() {
        testContext.getPageObjectManager().getMainScreen().selectChapter2();
        String abc  = (String) testContext.getScenarioContext().getContext(ContextEnum.DEMO);
        System.out.println("Data :--------------- \t" + abc);
    }
}
