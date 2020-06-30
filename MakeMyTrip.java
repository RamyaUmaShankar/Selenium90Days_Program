import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class MakeMyTrip {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//div[@class='loginModal displayBlock modalLogin dynHeight personal ']").click();
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.findElementByXPath("//span[text()='Hotels']").click();
		driver.findElementByXPath("//input[@id='city']").click();
		driver.findElementByXPath("//input[@id='city']").sendKeys("Goa",Keys.TAB);
		
		//driver.findElementByXPath("//span[@aria-label='Next Month']").click();
		driver.findElementByXPath("(//div[text()='15'])[1]").click();
		driver.findElementByXPath("(//div[text()='19'])[1]").click();
		driver.findElementByXPath("//input[@id='guest']").click();
		
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		WebElement eleChildAge = driver.findElementByXPath("//select[@data-cy='childAge-0']");
		Select select=new Select(eleChildAge);
		select.selectByVisibleText("12");

		driver.findElementByXPath("//button[@data-cy='submitGuest']").click();
		driver.findElementByXPath("//button[@data-cy='submit']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
		
		WebElement eleLocality = driver.findElementByXPath("//input[@id='mmLocality_checkbox_35']");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", eleLocality);
		
		WebElement eleRating = driver.findElementByXPath("//label[text()='3 & above (Good)']");
		js.executeScript("arguments[0].click()", eleRating);
		
		driver.findElementByXPath("//span[@class='customSelectTitle blueText latoBold']").click();
		driver.findElementByXPath("//li[text()='Price - Low to High']").click();
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.findElementByXPath("(//p[@id='hlistpg_hotel_name'])[2]").click();
		
			
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		System.out.println(driver.findElementById("detpg_hotel_name").getText());
		driver.findElementById("detpg_multi_view_combo").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='Book this combo']").click();
		
		System.out.println(driver.findElementById("revpg_total_payable_amt").getText());
		driver.close();
		
}

}
