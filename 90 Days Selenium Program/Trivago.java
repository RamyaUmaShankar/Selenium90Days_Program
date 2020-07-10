package v2_90DaysProgram;

import java.util.List;
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

public class Trivago {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Actions action;
		WebDriverWait wait;

		driver.get("https://www.trivago.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra, Uttar pradesh",Keys.TAB);

		driver.findElementByXPath("//div[@class='calendar-button-wrapper calendar-button-wrapper--checkin']/button").click();
		action=new Actions(driver);
		wait=new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='15']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='15']")).click().build().perform();


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='25']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='25']")).click().build().perform();

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		WebElement eleChild = driver.findElementByXPath("(//input[@class='input room-filters__input'])[2]");
		eleChild.clear();
		eleChild.sendKeys("1");
		driver.findElementByXPath("//label[text()='Children']").click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='select icon-bg-icn_arrow-sml-down dropdown-arrow ages-input__select']")));
		WebElement eleChildAge = driver.findElementByXPath("//select[@class='select icon-bg-icn_arrow-sml-down dropdown-arrow ages-input__select']");
		Select childAge=new Select(eleChildAge);
		childAge.selectByVisibleText("4");
		eleChildAge.click();


		WebElement eleApply=driver.findElementByXPath("(//button[text()='Apply'])[1]");
		eleApply.click();

		driver.findElementByXPath("//span[text()='Search']").click();

		driver.findElementByXPath("//span[text()='All types']").click();
		driver.findElementByXPath("//input[@value='Hotel']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class='icon-ic filter-components__starBtnIcon--97077 icon-center'])[4]").click();
		driver.findElementByXPath("//button[text()='Done']").click();

		Thread.sleep(2000);
		driver.findElementByXPath("//strong[text()='Guest rating']").click();
		driver.findElementByXPath("//span[text()='Very good']").click();


		driver.findElementByXPath("//li[@data-qa='location-filter']").click();
		WebElement eleHotelLocation = driver.findElementByXPath("//select[@id='pois']");
		eleHotelLocation.click();
		Select hotelLocationValue=new Select(eleHotelLocation);
		hotelLocationValue.selectByVisibleText("Agra Fort");
		driver.findElementByXPath("//button[text()='Done']").click();


		driver.findElementByXPath("//strong[text()='More filters']").click();
		driver.findElementByXPath("//label[text()='Air conditioning']//parent:: li//div/input").click();
		driver.findElementByXPath("//label[text()='WiFi']//parent:: li//div/input").click();
		driver.findElementByXPath("//label[text()='Restaurant']//parent:: li//div/input").click();
		driver.findElementByXPath("//button[text()='Done']").click();


		WebElement eleSort = driver.findElementByXPath("//select[@title='Sort by']");
		eleSort.click();
		Select sortOption=new Select(eleSort);
		sortOption.selectByVisibleText("Rating & Recommended");
		Thread.sleep(2000);


		System.out.print("Hotel Names: " );
		List<WebElement> eleHotelNames = driver.findElementsByXPath("//span[@class='item-link name__copytext']");
		for (WebElement a : eleHotelNames) {
			System.out.println(a.getText());

		}

		driver.close();
	}
}