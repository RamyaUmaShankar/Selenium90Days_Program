package v2_90DaysProgram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
1) Go to https://amazon.in
2) Enter "LG TV" in search box
3) Print the tv names and its prices only if the price is available in UI
*/

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.findElementByXPath("//input[@id='twotabsearchtextbox']").sendKeys("LG TV",Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> productNames = driver.findElementsByXPath("//span[@class='a-price-whole']/preceding::span[@class='a-size-medium a-color-base a-text-normal']");
		List<WebElement> productprices = driver.findElementsByXPath("//span[@class='a-price-whole']");
		
		for(int i=0; i<productNames.size(); i++)
		{
			System.out.print((i+1) + ".     "+ productNames.get(i).getText());
			System.out.print("---------->" + productprices.get(i).getText() + "\n");
		}

}
}