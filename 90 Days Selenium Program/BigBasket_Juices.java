package v2_90DaysProgram;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket_Juices {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		Actions action;
		WebDriverWait wait;
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		action=new Actions(driver);
		action.moveToElement(driver.findElementByXPath("//a[text()=' Shop by Category ']")).click().build().perform();
		
		
		action.moveToElement(driver.findElementByXPath("(//a[text()='Beverages'])[2]")).click().build().perform();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text()='Fruit Juices & Drinks'])[1]").click();
		Thread.sleep(2000);
			
		
		action.moveToElement(driver.findElementByXPath("(//span[text()='Juices'])[1]")).click().build().perform();
		Thread.sleep(2000);
		
		
		WebElement eleRealCheckbox = driver.findElementByXPath("(//span[text()='Real'])[1]");
		WebElement eleTropicanaCheckbox = driver.findElementByXPath("(//span[text()='Tropicana'])[1]");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", eleRealCheckbox);
		js.executeScript("arguments[0].click()", eleTropicanaCheckbox);
		Thread.sleep(2000);
		
		
		int tropicanaCount=driver.findElementsByXPath("//h6[text()='Tropicana']").size();
		int realCount=driver.findElementsByXPath("//h6[text()='Real']").size();
		int totalCount=driver.findElementsByXPath("//div[@qa='product_name']").size();
		System.out.println("Tropicana Juice Count: " + tropicanaCount);
		System.out.println("Real Juice Count: " + realCount);
		System.out.println("Total Juice Count: " + totalCount);
		
		
		List<WebElement> allButtons = driver.findElementsByXPath("//button[contains(@class,'btn btn-add')]");
		for (WebElement a : allButtons) {
			if (a.getText().equalsIgnoreCase("ADD")) {
				System.out.println("This product is available with ADD Button");
			} else {
				System.out.println("ADD button is not available for this product");
			}
		}
		
		driver.findElementByXPath("(//button[text()='Add '])[1]").click();
		driver.findElementByXPath("(//div[@qa='product_name'])[1]//a").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@id='mainHeader']/div/div/div[2]").click();
		
				
		driver.findElementByXPath("(//h4[text()='Select your city to start shopping']/parent::div/div)[1]/span").click();
		driver.findElementByXPath("//input[@placeholder='Select your city']").sendKeys("Chennai",Keys.TAB);
		driver.findElementByXPath("//input[@placeholder='Enter your area / apartment / pincode']").sendKeys("600007",Keys.TAB);
		driver.findElementByXPath("//button[text()='Continue']").click();
		
		action.moveToElement(driver.findElementByXPath("//div[@data-qa='myBasket']")).click().build().perform();
		String productText = driver.findElementByXPath("//div[@class='uHOi_']/div[2]").getText();
		String productCount = driver.findElementByXPath("//div[@class='_1pDjt']/div[2]").getText();
		String productPrice = driver.findElementByXPath("//div[@class='_2jeTu']/div[1]").getText();
		System.out.println("Product Name: " + productText);
		System.out.println("Product Count: " + productCount);
		System.out.println("Product Price: " + productPrice);
		
		driver.findElementByLinkText("View Basket & Checkout").click();
		driver.close();
	}
}


