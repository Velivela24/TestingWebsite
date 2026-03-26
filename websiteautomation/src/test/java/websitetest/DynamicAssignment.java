package websitetest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicAssignment {
	@Test
	public void DynamicTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		driver.navigate().to("https://the-internet.herokuapp.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dynamicEle = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));
		dynamicEle.click();

		WebElement enableEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Enable']")));
		enableEle.click();
		// driver.findElement(By.xpath("//button[text()='Enable']")).click();
		String display = enableEle.getText();
		 Assert.assertEquals(display, "Enable");
		 
		 WebElement disableEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Disable']")));
		 disableEle.click();
		// Assert.assertEquals(display,"Enable");
	}

}
