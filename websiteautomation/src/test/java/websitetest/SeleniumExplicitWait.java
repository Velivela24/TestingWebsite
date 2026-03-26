package websitetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class SeleniumExplicitWait {
@Test	
	public void testWait()
	{
		WebDriver driver = new ChromeDriver();
		Faker data = new Faker();
		driver.navigate().to("https://with-bugs.practicesoftwaretesting.com/#/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement emailEle = driver.findElement(By.xpath("//input[@id='email']"));
		wait.until(ExpectedConditions.visibilityOf(emailEle)).sendKeys(data.internet().emailAddress());
		
		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='password']"));
		wait.until(ExpectedConditions.visibilityOf(passwordEle)).sendKeys(data.internet().password());
		passwordEle.sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//input[@type='submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
		
		
	}


}
