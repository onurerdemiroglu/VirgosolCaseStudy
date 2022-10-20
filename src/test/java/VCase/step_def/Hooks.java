package VCase.step_def;

import VCase.utils.Driver;
import VCase.utils.Log4j;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setup(){
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\log4j.properties");
        Log4j.startLog();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed", new ByteArrayInputStream(screenshot));
        }
        Driver.closeDriver();
        Log4j.endLog();
    }

}
