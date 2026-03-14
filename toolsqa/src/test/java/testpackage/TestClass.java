package testpackage;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pagepackage.PageClass;

public class TestClass extends BaseClass{
	
	//find the total number of broken or working links
	@Test
	public void test() throws IOException, URISyntaxException {
		PageClass ob = new PageClass(driver);
		ob.clickAndSetValues();;
		ob.fillForm();
		
		List<WebElement> ebaylinklist = driver.findElements(By.tagName("a"));
		//get all attributes 
		for(WebElement toolsqalinks:ebaylinklist) {
			String href = toolsqalinks.getAttribute("href");
			String hrefName = toolsqalinks.getText();
					
			URI uri = new URI(href);
					
			HttpURLConnection httpUrlConnection = (HttpURLConnection)uri.toURL().openConnection();
			int responseCode = httpUrlConnection.getResponseCode();
			if(responseCode == 200) {
				System.out.println(hrefName+ "--" + href + "-->" + "success");
				}else {
					System.out.println(hrefName+ "--" + href + "-->" + "broken");
					}
			}
	}
	
	//open a new tab and switch back to parent window
	@Test
	public void openANewTab() {
		// Store parent window
		String parentWindow = driver.getWindowHandle();

		// Click action that opens new tab/window
		driver.findElement(By.id("openWindow")).click();

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Loop through windows
		for(String window : allWindows)
		{
		    if(!window.equals(parentWindow))
		    {
		        driver.switchTo().window(window);
		        break;
		    }
		}
		
		driver.switchTo().window(parentWindow);
	}
	
	//hard assertion title verification
	@Test
	public void titleVerification() {
		String expectedTitle = "Tools QA";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test failed");
		}
	}
	
	//hard assertion url verification
	@Test
	public void urlVerification() {
		String expectedURL = "https://www.toolsqa.com/";
		String currentURL = driver.getCurrentUrl();
		if(expectedURL.equals(currentURL)) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test failed");
		}
	}
	
	//to take screenshot of full page of tools qa
	@Test
	public void screenshot() throws IOException {
		//to take full page screenshot
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//to copy file to storage location
		FileHandler.copy(screenShot, new File("D:\\Screenshot\\toolsqa.png"));
	}
		
}

