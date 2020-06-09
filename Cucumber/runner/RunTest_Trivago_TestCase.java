package runner;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features= {"src\\test\\java\\feature\\trivago.feature"},
					glue="steps"
					,monochrome = true
					//,dryRun = true
					//,snippets=SnippetType.CAMELCASE
					)

public class RunTest_Trivago_TestCase extends AbstractTestNGCucumberTests {
	

}
