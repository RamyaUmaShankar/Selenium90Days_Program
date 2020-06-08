package steps;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Carwale {
	public  ChromeDriver driver;
	WebDriverWait wait;

@Given("Go to https:\\/\\/www.carwale.com\\/")
public void goToHttpsWwwCarwaleCom() {
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions(); 
	options.addArguments("--disable-notifications");
	driver=new ChromeDriver(options);
	driver.get("https://www.carwale.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
}

@Given("Click on Used")
public void clickOnUsed() throws InterruptedException {
			driver.findElement(By.xpath("//li[@data-tabs='usedCars']")).click();
			Thread.sleep(2000);
}

@Given("Select the City as Chennai")
public void selectTheCityAsChennai() throws InterruptedException {
//	wait.until(ExpectedConditions.visibilityOf(driver.findElementById("usedCarsList"))).sendKeys("Chennai",Keys.TAB);
	driver.findElementById("usedCarsList").sendKeys("Chennai"); 
	Thread.sleep(3000); 
	driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click(); 
	   
}

@Given("Select budget min and max and Click Search")
public void selectBudgetMinAndMaxAndClickSearch() {
    driver.findElementById("minInput").sendKeys("8");
    driver.findElementById("maxInput").sendKeys("12",Keys.ENTER);
    driver.findElementByXPath("//button[@id='btnFindCar']").click();
}

@Given("Select Cars with Photos under Only Show Cars With")
public void selectCarsWithPhotosUnderOnlyShowCarsWith() {
    driver.findElementByName("CarsWithPhotos").click(); 
}

@Given("Select Manufacturer as Hyundai")
public void selectManufacturerAsHyundai() throws InterruptedException {
	WebElement HyundaiEle = driver.findElementByXPath("//span[@class='filterText' and contains(text(),'Hyundai')]");
	JavascriptExecutor js= (JavascriptExecutor)driver;
	int y = HyundaiEle.getLocation().y+200;
	js.executeScript("window.scrollBy(0,"+y+")");
	Thread.sleep(3000);
	driver.findElementByXPath("//span[@class='filterText' and contains(text(),'Hyundai')]").click();
}

@Given("Select Fuel Type as Petrol")
public void selectFuelTypeAsPetrol() throws InterruptedException {
	 WebElement fuelTypeEle =driver.findElementByXPath("//h3[contains(text(),'Fuel Type')]");
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,"+(fuelTypeEle.getLocation().y)+")");
	  Thread.sleep(2000);
	
	  Actions builder= new Actions(driver);
	  builder.moveToElement(fuelTypeEle).click().perform();
	 
	 
	//wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[contains(text(),'Petrol')]")));
  driver.findElementByXPath("//span[contains(text(),'Petrol')]").click();
  Thread.sleep(3000);
    
}

@Given("Select Best Match as KM: Low to High")
public void selectBestMatchAs() {
	Select bestMatch=new Select(driver.findElementById("sort"));
	   bestMatch.selectByVisibleText("KM: Low to High");
   
}

@Given("Validate the Cars are listed with KMs Low to High")
public void validateTheCarsAreListedWithKMsLowToHigh() {
	
	String text = driver.findElementByXPath("(//div[@class='form-control-box']/select)[2]").getText();
	if(text.contains("Low to High"))
		System.out.println("The Cars are sorted with KM:Lowest to Highest and displayed");
	
	}
    


@Given("Add the least KM ran car to Wishlist")
public void addTheLeastKMRanCarToWishlist() {
	driver.findElementByPartialLinkText("Don't show anymore tips").click();
	Actions builder= new Actions(driver);
	WebElement shortListIcon = driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[1]");
	builder.moveToElement(shortListIcon).click().perform();
  
}

@Given("Go to Wishlist and Click on More Details")
public void goToWishlistAndClickOnMoreDetails() throws InterruptedException {
	driver.findElementByXPath("//li[@class='action-box shortlistBtn']").click();
	Thread.sleep(3000);
   	driver.findElementByXPath("(//div[@class='shortlistCardetails']/p)[6]").click();
}

@When("Print all the details under Overview in the Same way as displayed in application")
public void printAllTheDetailsUnderOverviewInTheSameWayAsDisplayedInApplication() {
	List<String>windowHandles = new LinkedList<String>(driver.getWindowHandles());
	  driver.switchTo().window(windowHandles.get(1));
	  WebElement overViewElements = driver.findElementByXPath("//div[@id='overview']//ul");
	  List<WebElement> listItems = overViewElements.findElements(By.tagName("li"));
	  System.out.println("\n");
	  for (WebElement webElement : listItems) {
		System.out.printf("%-50s%20s",webElement.findElement(By.xpath("div[1]")).getText(),webElement.findElement(By.xpath("div[2]")).getText()+"\n");
	}
	  driver.switchTo().window(windowHandles.get(0));
}

@Then("Close the browser.")
public void closeTheBrowser() {
  driver.quit();
}




}
