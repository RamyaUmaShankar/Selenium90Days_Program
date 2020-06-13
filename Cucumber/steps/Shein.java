package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shein {
	public ChromeDriver driver;
	Actions action;
	WebDriverWait wait;

	@Given("open https:\\/\\/www.shein.in\\/")
	public void openHttpsWwwSheinIn() {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get("https://www.shein.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("Mouseover on Clothing and click Jeans")
	public void mouseoverOnClothingAndClickJeans() throws InterruptedException {
		driver.findElementByXPath("//div[@class='c-coupon-box']//i").click();
		action=new Actions(driver);
		WebElement eleJeans = driver.findElementByXPath("(//a[@title='Jeans'])[1]");
		action.moveToElement(driver.findElementByXPath("//span[text()='CLOTHING']")).click(eleJeans).build().perform();
		Thread.sleep(1000);
	}

	@Given("Choose Black under Jeans product count")
	public void chooseBlackUnderJeansProductCount() {
		driver.findElementByXPath("//a[text()='Black']").click();
	}

	@Given("check size as medium")
	public void checkSizeAsMedium() throws InterruptedException {
		driver.findElementByXPath("(//li[@class='filter-title leftnav-first-title']//i)[3]").click();
		driver.findElementByXPath("(//div[@class='attr-group j-attr-group attr-group-size']//span[@class='attr-check-box'])[4]").click();
		Thread.sleep(4000);
	}

	@Given("User clicks + in color")
	public void clickColour() throws InterruptedException {
		String text = driver.findElementByXPath("//span[text()='Color']/ancestor::div//span[@class='attr-item-pic j-attr-item']//span").getText();
		Thread.sleep(3000);
	}

	@Given("check whether the color is black")
	public void checkWhetherTheColorIsBlack() {


		String text= driver.findElementByXPath("//span[text()='Color']/ancestor::div//span[@class='attr-item-pic j-attr-item']//span").getText();

		System.out.println("Colour Selected: " + text);

		if(text.contains("Black")) 
		{
			System.out.println("Selected products are black color");
		}
		else
			System.out.println("Product colour validation failed");




	}

	@Given("Click first item to Add to Bag")
	public void clickFirstItemToAddToBag() {
		driver.findElementByXPath("(//a[@class='c-goodsitem__goods-name j-goodsitem__goods-name '])[1]").click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));

	}

	@Given("Click the size as M and click Submit")
	public void clickTheSizeAsMAndClickSubmit() {
		driver.findElementByXPath("(//div[@class='product-intro__size-radio j-product-intro__size-radio'])[3]/span").click();

		driver.findElementByXPath("//div[@class='product-intro__add-btn']/button").click();
	}

	@Given("Click view Bag")
	public void clickViewBag() {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='view-bag']//a")));
		driver.findElementByXPath("//div[@class='view-bag']//a").click();

	}

	@When("Check the size is Medium or not.")
	public void checkTheSizeIsMediumOrNot() throws InterruptedException {
		Thread.sleep(5000);
		String sizeText = driver.findElementByXPath("//span[@class='gd-size']//em").getText();
		if(sizeText.equalsIgnoreCase("M"))
		{
			System.out.println("Selected Size is M");
		}
		else
			System.out.println("Selected size is not M");



	}

	@Then("close the browser.")
	public void closeTheBrowser() {
		driver.quit();
	}


}
