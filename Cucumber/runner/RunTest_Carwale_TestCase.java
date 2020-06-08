package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features= {"src\\test\\java\\feature\\carwale.feature"},
					glue="steps"
					,monochrome = true
					//,dryRun = true
					//,snippets=SnippetType.CAMELCASE
					)

public class RunTest_Carwale_TestCase extends AbstractTestNGCucumberTests {
	

}
