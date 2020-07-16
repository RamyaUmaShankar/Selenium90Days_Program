package v2_90DaysProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

/*
Load https://www.naukri.com/
You will get three different popup windows
Print the company names in the popup window and close the window
*/
public class Naukri {
	
		public static void main(String[] args)  {
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			
			//WebDriverWait wait;
			driver.get("https://www.naukri.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
				
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowHandlesList=new ArrayList<String>(windowHandles);
			int size = windowHandlesList.size(); 
			
			driver.switchTo().window(windowHandlesList.get(size-1));
			driver.manage().window().maximize();
			String a1 = driver.findElementByXPath("//a/img").getAttribute("alt");
			System.out.println("Company Name: " + a1);
			driver.close();
			
			driver.switchTo().window(windowHandlesList.get(size-2));
			driver.manage().window().maximize();
			String a2 = driver.findElementByXPath("//a/img").getAttribute("alt");
			System.out.println("Company Name: " + a2);
			driver.close();
			
			driver.switchTo().window(windowHandlesList.get(size-3));
			String a3 = driver.findElementByXPath("//a/img").getAttribute("alt");
			System.out.println("Company Name: " + a3);
			driver.close();
			
			
			driver.quit();

	}

}
