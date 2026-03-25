package websitetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class LoginPageTest {
	@Test
	public void loginPage() {
		WebDriver driver = new ChromeDriver();
		Faker data = new Faker();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		WebElement formAuthEle = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
		formAuthEle.click();
		WebElement loginPageHeadingEle = driver.findElement(By.xpath("//h2[text()='Login Page']"));
		String heading = loginPageHeadingEle.getText();
		Assert.assertEquals(heading,"Login Page");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		//Good Practice one assert in one method
	
	
	}

}
