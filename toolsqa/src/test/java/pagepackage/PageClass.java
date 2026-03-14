package pagepackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {
	WebDriver driver;
	WebDriverWait wait;
	
	//tutorials button
	@FindBy(xpath="/html/body/header/nav/div/div/div[4]")
	WebElement tutorials;
	
	//enroll buuton 
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div/div[2]/div[4]/div[1]/a")
	WebElement enrollnow;
	
	//enroll firstname
	@FindBy(id ="first-name")
	WebElement firtsName;
	
	//enroll lastname
	@FindBy(id ="last-name")
	WebElement lastName;
	
	//enroll email
	@FindBy(id ="email")
	WebElement email;
	
	//enroll mobile
	@FindBy(id ="mobile")
	WebElement mobile;
	
	//enroll country dropdown
	@FindBy(id ="country")
	WebElement country;
	
	//enroll city
	@FindBy(id ="city")
	WebElement city;
	
	//enroll message
	@FindBy(id ="message")
	WebElement message;
	
	public PageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void clickAndSetValues() {

	    wait.until(ExpectedConditions.elementToBeClickable(tutorials)).click();

	    WebElement enroll = wait.until(ExpectedConditions.elementToBeClickable(enrollnow));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", enroll);

	    js.executeScript("arguments[0].click();", enroll);
	}
	
	public void fillForm() {
		 wait.until(ExpectedConditions.visibilityOf(firtsName)).sendKeys("Hemanth");
		 wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("R");
		 wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("abc@gmail.com");
		 wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys("8129726781");
		 wait.until(ExpectedConditions.visibilityOf(city)).sendKeys("Kollam");
		 wait.until(ExpectedConditions.visibilityOf(message)).sendKeys("Hai");
	}

}
