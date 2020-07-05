package v2_90DaysProgram;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Pepperfry {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElementByXPath("//div[@id='regPopUp']/a").click();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElementByXPath("(//a[text()='Furniture'])[1]")).build().perform();
		driver.findElementByXPath("(//a[text()='Office Chairs'])[1]").click();
		driver.findElementByXPath("//h5[text()='Executive Chairs']").click();
		Thread.sleep(2000);
		
		WebElement eleHeight=driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);",eleHeight);
		eleHeight.clear();
		eleHeight.sendKeys("50");
		Thread.sleep(2000);
		
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElementByXPath("//span[@class='wewidgeticon we_close icon-large']").click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[@data-tooltip='Add to Wishlist'])[6]").click();
		Thread.sleep(2000);
		WebElement eleFurniture=driver.findElementByXPath("(//a[text()='Furniture'])[1]");
		js.executeScript("arguments[0].scrollIntoView(false);", eleFurniture);
		action.moveToElement(driver.findElementByXPath("(//a[text()='Furniture'])[1]")).build().perform();
		driver.findElementByXPath("//a[text()='Office Tables']").click();
		driver.findElementByXPath("//h5[text()='Executive Desks']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//li[@data-search='20000-40000']/label").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@id='clip_wishlist_']").click();
		
		String count = driver.findElementByXPath("//div[@class='wishlist_bar']/span").getText();
		int intCount=Integer.parseInt(count);
		if(intCount==2)
		{
			System.out.println("Items Validated");
		}
		
		
		driver.findElementByXPath("//div[@class='wishlist_bar']").click();
		String offerPrice = driver.findElementByXPath("(//p[@class='oprice'])[1]/span[2]").getText();
		offerPrice=offerPrice.replaceAll("[^0-9]", "");
		System.out.println(offerPrice);
		int intofferPrice=Integer.parseInt(offerPrice);
		System.out.println(intofferPrice);
		
		String offerCode = driver.findElementByXPath("(//p[@class='pf-border pf-border-lighter-grey-50 pf-border-style-dashed pf-center pf-padding-tiny font-14 pf-italic-txt pf-text-grey pf-margin-top use-coupon'])[1]/strong").getText();
		System.out.println("Offer Code: " + offerCode);
		driver.findElementByXPath("(//a[@class='addtocart_icon'])[1]").click();
		driver.findElementByXPath("//div[@class='pin_block']//input").sendKeys("600128");
		driver.findElementByXPath("//div[@class='pin_block']//a").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//input[@id='coupon_code']").sendKeys(offerCode);
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='cpn_check_btn']").click();
		driver.findElementByXPath("(//a[text()='PLACE ORDER'])[1]").click();
		driver.findElementByXPath("(//div[@class='nCheckout__accrodian-header-right'])[1]/span").click();
		
		WebElement eleImg = driver.findElementByXPath("//input[@class='product_details']/parent::li");
		File source= eleImg.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("D:\\pageScreenshot.png"));
	
	
	
	
	}
}
