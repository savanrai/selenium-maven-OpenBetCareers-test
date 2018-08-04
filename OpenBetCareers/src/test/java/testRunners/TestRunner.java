package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/StepDefinition", 
		glue = "stepDefinations",
		plugin = { "pretty", "html:target/cucumber-reports" }
		)
public class TestRunner {

}
