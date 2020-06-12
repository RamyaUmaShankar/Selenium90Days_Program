package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features= {"src\\test\\java\\feature\\shopclues.feature"},
					glue="steps"
					,monochrome = true
					//,dryRun = true
					//,snippets=SnippetType.CAMELCASE
					)

public class RunTest_Shopcules_TestCase extends AbstractTestNGCucumberTests {
	

}
