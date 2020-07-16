package v2_90DaysProgram;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/*
Goto https://autoportal.com/
Select Location as Chennai
Select Car Brand as Renault
Select Model as Arkana
Search for the car
Print the expected price
*/

public class AutoPortal {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://autoportal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElementByXPath("//div[@class='maincity-in field']").click();
		driver.findElementById("ac_user_city").sendKeys("chennai");
		driver.findElementByXPath("(//li[@class='ui-menu-item'])[1]//span").click();
		driver.findElementByXPath("//span[text()='Confirm City']").click();
		
		Thread.sleep(2000);
		WebElement eleBrand = driver.findElementByXPath("//select[@name='brand']");
		Select select=new Select(eleBrand);
		select.selectByVisibleText("Renault");
		
		Thread.sleep(2000);
		WebElement eleModel = driver.findElementByXPath("//select[@name='model']");
		Select select2=new Select(eleModel);
		select2.selectByVisibleText("Arkana");
		
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@value='Find new cars']").click();
		
		Thread.sleep(3000);
		System.out.println(driver.findElementByXPath("//div[@class='nm_price-launch-date']//div[1]").getText());
		driver.close();
		
	}
}
