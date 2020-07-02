package v2_90DaysProgram;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Azure 
{

	public static void downloadFileValidation(String fileName)
	{
		String downloadPath="C:\\Users\\Ramya\\Downloads";
		File dir=new File(downloadPath);
		File[] dirContents=dir.listFiles();
		for(int i=0;i<dirContents.length; i++)
		{
			if(dirContents[i].getName().equalsIgnoreCase(fileName))
			{
				System.out.println("File was downloaded suceesfully in the Downloads Folder");
				break;
			}
		}
		
	}

	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://azure.microsoft.com/en-in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.findElementByXPath("//a[@id='navigation-pricing']").click();
	driver.findElementByXPath("(//a[@data-bi-id='global-navigation-secondarynav-clicked-topmenu'])[2]").click();
	driver.executeScript("window.scrollBy(0,200)");
	driver.findElementByXPath("//button[@data-event-property='containers']").click();
	driver.findElementByXPath("(//button[@title='Container Instances'])[2]").click();
	driver.findElementByXPath("//button[@id='new-module-loc']").click();
	
	
	WebElement eleRegion = driver.findElementByXPath("(//select[@name='region'])[1]");
	Select s=new Select(eleRegion);
	s.selectByVisibleText("South India");
	driver.findElementByXPath("(//input[@aria-label='Seconds'])[1]").click();
	driver.findElementByXPath("(//input[@aria-label='Seconds'])[1]").clear();
	driver.findElementByXPath("(//input[@aria-label='Seconds'])[1]").sendKeys(Keys.BACK_SPACE);
	driver.findElementByXPath("(//input[@aria-label='Seconds'])[1]").sendKeys("180000");
	
	WebElement eleMemory = driver.findElementByXPath("(//select[@aria-label='Memory'])[1]");
	Select s1=new Select(eleMemory);
	s1.selectByVisibleText("4 GB");
	
	driver.executeScript("window.scrollBy(0,350)");
	driver.findElementByXPath("//button[@id='devtest-toggler']").click();
	
	WebElement eleCurrency = driver.findElementByXPath("//select[@class='select currency-dropdown']");
	Select s2=new Select(eleCurrency);
	s2.selectByVisibleText("Indian Rupee (₹)");
	
	Thread.sleep(2000);
	System.out.println("Estimated Monthly Cost: " + driver.findElementByXPath("//div[@class='column large-3 text-right total']/div[2]/span").getText());
	driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();

	downloadFileValidation("ExportedEstimate.xlsx");
	System.out.println("Done");
	
	
	WebElement eleExampleScenario = driver.findElementByXPath("//a[text()='Example Scenarios']");
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(false);", eleExampleScenario);
	Thread.sleep(2000);
	
	eleExampleScenario.click();
	driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
	driver.findElementByXPath("//button[text()='Add to estimate']").click();
	Thread.sleep(2000);
	
	WebElement eleCurrency2 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
	Select s3=new Select(eleCurrency2);
	s3.selectByVisibleText("Indian Rupee (₹)");
	
	js.executeScript("arguments[0].scrollIntoView(false);", eleCurrency2);
	eleCurrency2.click();
	s3.selectByVisibleText("Indian Rupee (₹)");
	driver.findElementByXPath("//button[@id='devtest-toggler']").click();
	driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
	
	downloadFileValidation("ExportedEstimate (1).xlsx");

	System.out.println("Done");
	

}
}