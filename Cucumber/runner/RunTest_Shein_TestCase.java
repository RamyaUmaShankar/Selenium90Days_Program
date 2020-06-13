package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features= {"src\\test\\java\\feature\\shein.feature"},
					glue="steps"
					,monochrome = true
					//,dryRun = true
					//,snippets=SnippetType.CAMELCASE
					)

public class RunTest_Shein_TestCase extends AbstractTestNGCucumberTests {
	

}
