package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReports.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@product",
        dryRun = false
)
public class CukesRunner {


}
