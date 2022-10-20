package VCase.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty"
        },
        glue= {"VCase.step_def"},
        features = "src/test/java/VCase/features",
        tags = "@positive",
        dryRun = false
)
public class CucumberRunner {

}
