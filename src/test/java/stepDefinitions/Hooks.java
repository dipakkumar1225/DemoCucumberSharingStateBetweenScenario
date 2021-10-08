package stepDefinitions;

import io.cucumber.java.*;
import org.imgscalr.Scalr;
import org.openqa.selenium.OutputType;
import testutilities.context.ContextEnum;
import testutilities.context.TestContext;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context) {
        this.testContext = context;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        boolean isChapter1ContentDisplayed = testContext.getPageObjectManager().getMainScreen().isChapter1ContentDisplayed();
        System.out.println("inside before hooks executed \t" + isChapter1ContentDisplayed);
        testContext.getScenarioContext().setScenarioContext(ContextEnum.DEMO, isChapter1ContentDisplayed);
    }

    @AfterStep
    public void takeScreenShotsOnStepFailure(Scenario scenario) {
        if ((scenario.isFailed()) || (scenario.getStatus().toString().equals("SKIPPED"))) {
            byte[] screenshot = testContext.getAppiumDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(resizeBytesImage(screenshot), "image/png", scenario.getName());
        }
    }

    private byte[] resizeBytesImage(byte[] image) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(image);
        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(byteArrayInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_BGR);
        newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
        newBufferedImage = Scalr.resize(newBufferedImage, Scalr.Method.ULTRA_QUALITY, newBufferedImage.getWidth() / 3, newBufferedImage.getHeight() / 3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ImageIO.write(newBufferedImage, "JPG", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toByteArray();
    }

}
