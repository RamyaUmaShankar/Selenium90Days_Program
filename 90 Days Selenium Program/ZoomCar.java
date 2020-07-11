package v2_90DaysProgram;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
09/07/2020
===========
1. Go to https://www.zoomcar.com/chennai
2. Click on Start your wonderful journey
3. Select  any location under POPULAR PICK-UP POINTS and click next
4. Select tomorrow's date and time as 9:00 AM as start date and time and Click Next
5. Click on Show More and Select tomorrow's date and Select time as 6:00 PM as end date  and Click Done
6.  Take the snapshot for PICKUP TIME and DROP OFF TIME
7. Validate the pickup time and Drop off time are correct (as you selected) and click on Done
8. Click on Price: High to Low and validate the sort order of the car price programmatically
9. Print all the Car name and respective Price from High to Low ( car name -- price )
10. Take snapshot of the details for the Highest price car
11. Click on Know More for the Highest price car and print the rate after 45Kms
12. Close the Browser

*/
public class ZoomCar {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElementByXPath("//a[@title='Start your wonderful journey']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class='component-popular-locations']/div[2]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		driver.findElementByXPath("//div[@class='days']/div[2]/div").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[text()='09:00'])[1]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		
		driver.findElementByXPath("//div[@class='show-more']").click();
		driver.findElementByXPath("//li[@class='inactive low-price']/following-sibling::li[1]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[text()='18:00'])[1]").click();
		driver.findElementByXPath("//button[text()='Done']").click();
		
		WebElement eleSnapDuration = driver.findElementByXPath("//div[@class='duration-details']");
		File source= eleSnapDuration.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("D:\\DurationSnap.png"));
	
		String pickupTime = driver.findElementByXPath("(//div[@class='time'])[1]//div[2]").getText();
		String DropTime = driver.findElementByXPath("(//div[@class='time'])[2]//div[2]").getText();
		if(pickupTime.equalsIgnoreCase("09:00 AM") && DropTime.equalsIgnoreCase("06:00 PM"))
		{
			System.out.println("Pickup and droptime are validated and it is correct");
		}
		
		
		Thread.sleep(1000);
		driver.findElementByXPath("//div[text()=' Price: High to Low ']").click();
		List<WebElement> eleCarPrices = driver.findElementsByXPath("//div[@class='new-price']");
		List<Integer> ls=new ArrayList<Integer>();
		System.out.println("Price displayed in the UI: ");
		for (WebElement s : eleCarPrices) {
			String text1 = s.getText().replaceAll("[^0-9]", "");
			System.out.println(text1);
			int i=Integer.parseInt(text1);
			ls.add(i);
		}
		
		Collections.sort(ls);
		Collections.reverse(ls);
		System.out.println("Price Validation from high to low programmatically");
		System.out.println(ls);
		
		driver.findElementByXPath("//div[text()=' Price: High to Low ']").click();
		List<WebElement> eleCarNames = driver.findElementsByXPath("//div[@class='details']/h3");
		System.out.println("Car Name: ----- Price");
		for(int i=0; i<eleCarNames.size(); i++)
		{
			System.out.println(eleCarNames.get(i).getText() + "----" + eleCarPrices.get(i).getText().replaceAll("[^0-9]", ""));
		}
		
		WebElement eleSnapMaxCar = driver.findElementByXPath("(//div[@class='car-item'])[1]/div[1]");
		File source2= eleSnapMaxCar.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2, new File("D:\\CarSnap.png"));
		
		driver.findElementByXPath("(//div[@class='know-more-details'])[1]").click();
		System.out.println("Car Price after 45 kms: " + driver.findElementByXPath("(//div[@class='price-info'])[1]").getText());
		
		driver.quit();
}
}