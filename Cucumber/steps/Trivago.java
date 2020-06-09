package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Trivago {
	public  ChromeDriver driver;
	Actions action;
	WebDriverWait wait;

	
	@Given("Go to https:\\/\\/www.trivago.com\\/")
	public void goToHttpsWwwTrivagoCom() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.trivago.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    
	}

	@Given("Type Agra in Destination and select Agra, Uttar Pradesh.")
	public void typeAgraInDestinationAndSelectAgraUttarPradesh() {
	  driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra, Uttar pradesh",Keys.TAB);
	}

	@Given("Choose check in and check out date")
	public void chooseCheckInAndCheckOutDate() {
		driver.findElementByXPath("//div[@class='calendar-button-wrapper calendar-button-wrapper--checkin']/button").click();
		action=new Actions(driver);
		wait=new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='15']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='15']")).click().build().perform();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='30']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='30']")).click().build().perform();
	  
	}
	

	@Given("Select Room as Family Room")
	public void selectRoomAsFamilyRoom() {
		driver.findElementByXPath("//span[text()='Family rooms']").click(); 
	}

	@Given("Choose Number of Adults Two, Childern One and set Child's Age as Four")
	public void chooseNumberOfAdultsTwoChildernOneAndSetChildSAgeAsFour() {
		WebElement eleChild = driver.findElementByXPath("//select[@id='select-num-children-2']");
		Select child=new Select(eleChild);
		child.selectByVisibleText("1");
		
		WebElement eleChildAge = driver.findElementByXPath("//select[@id='select-ages-children-2-3']");
		Select childAge=new Select(eleChildAge);
		childAge.selectByVisibleText("4");  
	}

	@Given("Click Confirm button and click Search")
	public void clickConfirmButtonAndClickSearch() {
		driver.findElementByXPath("//span[text()='Confirm']").click();
		driver.findElementByXPath("//span[text()='Search']").click();
	   
	}

	@Given("Select Accommodation type as Hotels only and choose Four stars")
	public void selectAccommodationTypeAsHotelsOnlyAndChooseFourStars() throws InterruptedException {
		driver.findElementByXPath("//span[text()='All types']").click();
		driver.findElementByXPath("//input[@value='Hotels only']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='refinement-row__content']//button[@title='4-star hotels']").click();
		driver.findElementByXPath("//button[text()='Done']").click();
 
	}

	@Given("Select Guest rating as Very Good")
	public void selectGuestRatingAsVeryGood() {
		driver.findElementByXPath("//strong[text()='Guest rating']").click();
		driver.findElementByXPath("//span[text()='Good']").click();
  
	}

	@Given("Set Hotel Location as Agra Fort and click Done")
	public void setHotelLocationAsAgraFortAndClickDone() {
		driver.findElementByXPath("//li[@data-qa='location-filter']").click();
		WebElement eleHotelLocation = driver.findElementByXPath("//select[@id='pois']");
		eleHotelLocation.click();
		Select hotelLocationValue=new Select(eleHotelLocation);
		hotelLocationValue.selectByVisibleText("Agra Fort");
		driver.findElementByXPath("//button[text()='Done']").click();

	}

	@Given("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void inMoreFiltersSelectAirConditioningRestaurantAndWiFiAndClickDone() {
		driver.findElementByXPath("//strong[text()='More filters']").click();
		driver.findElementByXPath("//label[text()='Air conditioning']//parent:: li//div/input").click();
		driver.findElementByXPath("//label[text()='WiFi']//parent:: li//div/input").click();
		driver.findElementByXPath("//label[text()='Restaurant']//parent:: li//div/input").click();
		driver.findElementByXPath("//button[text()='Done']").click();

	}

	@Given("Sort the result as Rating & Recommended")
	public void sortTheResultAsRatingRecommended() throws InterruptedException {
		WebElement eleSort = driver.findElementByXPath("//select[@title='Sort by']");
		eleSort.click();
		Select sortOption=new Select(eleSort);
		sortOption.selectByVisibleText("Rating & Recommended");
		Thread.sleep(2000);

	}

	@Given("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void printTheHotelNameRatingNumberOfReviewsAndClickViewDeal() {
		System.out.println("Hotel Name: " + driver.findElementByXPath("(//div[@class='item__name item__name--link']//h3/span)[1]").getText());
		System.out.println("Hotel Rating: " + driver.findElementByXPath("(//span[@class='review']/span/span)[1]").getText());
		System.out.println("Hotel Review: " + driver.findElementByXPath("(//span[@class='details-paragraph details-paragraph--rating'])[1]").getText().replaceAll("[^0-9]", ""));
		driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();
  
	}

	@Given("Print the URL of the Page")
	public void printTheURLOfThePage() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println("URL: " + driver.getCurrentUrl());

	}

	@Given("Print the Price of the Room and click Choose Your Room")
	public void printThePriceOfTheRoomAndClickChooseYourRoom() {
		System.out.println("Price: " + driver.findElementByXPath("(//div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper'])[1]").getText());
		driver.findElementByLinkText("Executive Double Room").click();
		
	}

	@When("Click Reserve and I'll Reserve")
	public void clickReserveAndILlReserve() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		driver.findElementByXPath("(//td[@class='submitButton']//a)[2]").click();
		//to click the reserve button
		//driver.findElementByXPath("//div[@class='hprt-reservation-cta']/button");
	}

	@Then("Close the browser")
	public void closeTheBrowser() {
		
		driver.quit();
	   
	}



}
