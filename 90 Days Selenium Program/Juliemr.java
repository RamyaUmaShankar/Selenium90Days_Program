package v2_90DaysProgram;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Juliemr {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElementByXPath("//input[@ng-model='first']").sendKeys("5");
		WebElement eleOperator=driver.findElementByXPath("//select[@ng-model='operator']");
		Select select =new Select(eleOperator);
		select.selectByVisibleText("*");

		driver.findElementByXPath("//input[@ng-model='second']").sendKeys("5");
		driver.findElementById("gobutton").click();
		WebElement result = driver.findElementByXPath("//h2[@class='ng-binding']");


		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(result, "25"));

		System.out.println("Wait completed");

		System.out.println(result.getText());

		driver.close();


	}

}
