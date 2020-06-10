package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Ajio {

	public ChromeDriver driver;

@Given("Go to https:\\/\\/www.ajio.com\\/")
public void goToHttpsWwwAjioCom() {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver=new ChromeDriver(options);
	driver.get("https://www.ajio.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
public void mouseoverOnWomenCATEGORIESAndClickOnKurtas() {
	driver.findElementByLinkText("Women").click();
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElementByLinkText("WOMEN")).build().perform();
	driver.findElementByLinkText("Kurtas").click();

}

@Given("Click on Brands and choose Ajio")
public void clickOnBrandsAndChooseAjio() {
	driver.findElementByXPath("//span[text()='brands']").click();
	WebElement eleBrands = driver.findElementByXPath("//div[@class='facet-linkhead']//label[@class='facet-linkname facet-linkname-brand facet-linkname-AJIO']");
	eleBrands.click();

}

@Given("Check all the results are Ajio")
public void checkAllTheResultsAreAjio() throws InterruptedException {
	WebElement eleBrands = driver.findElementByXPath("//div[@class='facet-linkhead']//label[@class='facet-linkname facet-linkname-brand facet-linkname-AJIO']");
	Thread.sleep(2000);
	String count = eleBrands.getText().replaceAll("[^0-9]", "");
	System.out.println(count);
	Thread.sleep(2000);
	WebElement eleBrandsPreviewPage = driver.findElementByXPath("//div[@class='length']");
	String count2 = eleBrandsPreviewPage.getText().replaceAll("[^0-9]", "");
	System.out.println(count2);
	if(count.equals(count2))
		System.out.println("All all the displayed items are belongs to AJIO");
   
}

@Given("Set Sort by the result as Discount")
public void setSortByTheResultAsDiscount() {
	WebElement eleSortDropdown = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
	Select select=new Select(eleSortDropdown);
	select.selectByVisibleText("Discount");
  
}

@Given("Select the Color and click ADD TO BAG")
public void selectTheColorAndClickADDTOBAG() {
	driver.findElementByXPath("(//div[@class='imgHolder'])[1]").click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowHandlesList=new ArrayList<String>(windowHandles);
	driver.switchTo().window(windowHandlesList.get(1));
	//System.out.println(driver.getCurrentUrl());
	driver.findElementByXPath("(//div[@class='color-swatch'])[2]/a").click();
	driver.findElementByXPath("//span[text()='ADD TO BAG']").click();

}

@Given("Verify the error message Select your size to know your estimated delivery date")
public void verifyTheErrorMessageSelectYourSizeToKnowYourEstimatedDeliveryDate() throws InterruptedException {
	Thread.sleep(2000);
	String errorText=driver.findElementByXPath("//span[text()='Please select a size']").getText();
	if(errorText.contains("Please select a size"))
		System.out.println("Error Message Displayed As Expected");
   
}

@Given("Select size and click ADD TO BAG")
public void selectSizeAndClickADDTOBAG() {
	driver.findElementByXPath("(//div[text()='XS'])[1]").click();
	driver.findElementByXPath("//span[text()='ADD TO BAG']").click();

}

@Given("click on Enter pin-code to know estimated delivery date")
public void clickOnEnterPinCodeToKnowEstimatedDeliveryDate() throws InterruptedException {
	Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, 30);

	wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(
			"//span[text()='Enter Pin-code To Know Estimated Delivery Date']")));
	driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();


	Thread.sleep(3000);

}

@Given("Enter the pincode and click Confirm pincode")
public void enterThePincodeAndClickConfirmPincode() throws InterruptedException {
	driver.findElementByClassName("edd-pincode-modal-text").sendKeys("600007");
	driver.findElementByClassName("edd-pincode-modal-submit-btn").click();
	Thread.sleep(2000);

}

@When("Print the message and click Go to Bag")
public void printTheMessageAndClickGoToBag() {
	String msg = driver.findElementByClassName("edd-message-success-details").getText();
	System.out.println("Delivery message is: " + msg);

	driver.findElementByXPath("//span[text()='ADD TO BAG']").click();

}

@Then("Click on Proceed to Shipping and clode the browser")
public void clickOnProceedToShippingAndClodeTheBrowser() {
	driver.findElementByXPath("//button[text()='Proceed to shipping']").click();
	driver.quit();
   }



}
