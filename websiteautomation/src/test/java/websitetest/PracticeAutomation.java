package websitetest;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PracticeAutomation {
	

	@Test
	public void websiteForm()
	{
	Faker data = new Faker();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().fullscreen();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	driver.get("https://with-bugs.practicesoftwaretesting.com/#/auth/register");
	WebElement firstNameEle= driver.findElement(By.xpath("//input[@id='first_name']"));
	firstNameEle.sendKeys(data.name().firstName());
	WebElement lastNameEle = driver.findElement(By.xpath("//input[@id='last_name']"));
	lastNameEle.sendKeys(data.name().lastName());
	WebElement dateOfBirth = driver.findElement(By.xpath("//input[@id='dob']"));
	Date dob = data.date().birthday();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	dateOfBirth.sendKeys(sdf.format(dob));
	//dateOfBirth.sendKeys(data.date().birthday().toString());
	
	WebElement AddressEle = driver.findElement(By.xpath("//input[@id='address']"));
	AddressEle.sendKeys(data.address().streetAddress());

	WebElement PostalCodeEle = driver.findElement(By.xpath("//input[@id='postcode']"));
	PostalCodeEle.sendKeys(data.address().zipCode());

	WebElement CityEle = driver.findElement(By.xpath("//input[@id='city']"));
	CityEle.sendKeys(data.address().cityName());

	WebElement StateEle = driver.findElement(By.xpath("//input[@id='state']"));
	StateEle.sendKeys(data.address().state());

	WebElement CountryDropdown= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='country']")));
	CountryDropdown.click();
	driver.findElement(By.xpath("//option [@value = 'CA']")).click();
	
	//WebElement CountryEle = driver.findElement(By.xpath("//input[@id='country']"));

	WebElement PhoneEle = driver.findElement(By.xpath("//input[@id='phone']"));
	PhoneEle.sendKeys(data.phoneNumber().cellPhone());

	WebElement EmailEle = driver.findElement(By.xpath("//input[@id='email']"));
	EmailEle.sendKeys(data.internet().emailAddress());

	WebElement PasswordEle = driver.findElement(By.xpath("//input[@id='password']"));
	PasswordEle.sendKeys(data.internet().password());
	
	WebElement RegisterButton= driver.findElement(By.xpath("//button[@type='submit']"));
	RegisterButton.click();

	
 driver.quit();
	
	
	
	
	
	
	
	
	}
	
	
	
}