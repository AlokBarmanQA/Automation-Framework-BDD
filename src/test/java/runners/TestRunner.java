package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions"
//				, "appHooks"
				},
		plugin = {"pretty", "html:target/cucumber-report"}
//		,monochrome = true,// does not need it if use pretty but need to add ANSI Escape in Console
//		tags= "@all"
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
