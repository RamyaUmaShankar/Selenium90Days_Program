package v2_90DaysProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjioTestCase {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	
		
		driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']").sendKeys("bags");
		driver.findElementByXPath("//ul[@class='rilrtl-list ']//li[3]").click();
		
		driver.findElementByXPath("//div[@class='five-grid']").click();
		WebElement eleSort = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		eleSort.click();
		driver.findElementByXPath("//option[@value='newn']").click();
		
		driver.findElementByXPath("(//div[@class='cat-facets '])[3]/div").click();
		driver.findElementByXPath("//input[@id='minPrice']").sendKeys("2500");
		driver.findElementByXPath("//input[@id='maxPrice']").sendKeys("5000");
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		
		Thread.sleep(2000);
		String bagName="TOMMY HILFIGER Sling Bag with Chain Strap";
		List<WebElement> allBrands = driver.findElementsByXPath("//div[@class='contentHolder']/div[1]");
		List<WebElement> allBrandNames = driver.findElementsByXPath("//div[@class='contentHolder']/div[2]");
		for(int i=0;i<allBrands.size();i++)
		{
		String str=allBrands.get(i).getText() + " " + allBrandNames.get(i).getText();
		if(str.equalsIgnoreCase(bagName))
		{
			System.out.println("Clicked" + bagName);
			allBrands.get(i).click();
			break;
		}
		}
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		String price = driver.findElementByXPath("//div[@class='prod-sp']").getText().replaceAll("[^0-9]", "");
		System.out.println("Price Amount: " + price);
		int p=Integer.parseInt(price);
		String offerCode="", discountPrice="";
		if(p>2890)
		{
		
		offerCode=driver.findElementByXPath("//div[@class='promo-title']").getText();
		offerCode=offerCode.replaceAll("Use Code","");
		System.out.println("Offer Code: " + offerCode);
		
		discountPrice=driver.findElementByXPath("//div[@class='promo-discounted-price']/span").getText().replaceAll("[^0-9]", "");
		
		
		}
		
		int dp=Integer.parseInt(discountPrice);
		System.out.println("Discount Price: " + dp);
		driver.findElementByXPath("//span[@class='edd-pincode-msg-details edd-pincode-msg-details-pointer edd-pincode-msg-details-text-color']").click();
		driver.findElementByXPath("//input[@name='pincode']").click();
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("560043");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		String deliveryDate = driver.findElementByXPath("//ul[@class='edd-message-success-details']/li/span").getText();
		System.out.println("Delivery Date: " + deliveryDate);
		
		
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		driver.executeScript("window.scrollBy(0,450)");
		Thread.sleep(2000);
		String customerCareDetails=driver.findElementByXPath("(//li[@class='detail-list mandatory-info'])[7]/span[3]").getText();
		System.out.println("Customer care details: " + customerCareDetails);
		
		WebElement eleCart = driver.findElementByXPath("//span[text()='ADD TO BAG']");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(false);", eleCart);
		Thread.sleep(2000);
		driver.findElementByXPath("//span[@class='ic-pdp-add-cart']").click();
		
		Thread.sleep(4000);
		driver.findElementByXPath("//span[text()='GO TO BAG']").click();
	
		Thread.sleep(4000);
		String orderTotal = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
		orderTotal=orderTotal.replaceAll("[^0-9]", "");
		int o=Integer.parseInt(orderTotal)/100;
		System.out.println("Order Total: " + o);
		if(p==o)
		{
			driver.findElementById("couponCodeInput").sendKeys(offerCode);
			driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		}
		
		Thread.sleep(4000);
		String discountPriceNew = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
		discountPriceNew=discountPriceNew.replaceAll("[^0-9]", "");
		int dpo=Integer.parseInt(discountPriceNew)/100;
		System.out.println("Discount price after entering the offer code: " + dpo);
		if(dp==dpo)
		{
			System.out.println("Discount Price is same as product price after entering the offer code");
		}
		
		driver.findElementByXPath("//div[@class='delete-btn']").click();
		driver.findElementByXPath("(//div[@class='delete-btn'])[2]").click();
		
		driver.quit();
		
		
		
	}
}
