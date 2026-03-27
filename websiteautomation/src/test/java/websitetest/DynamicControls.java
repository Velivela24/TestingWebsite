package websitetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls {
@Test
	public void dynamicRemoveTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		driver.navigate().to("https://the-internet.herokuapp.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dynamicEle = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));
		dynamicEle.click();

		WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
		wait.until(ExpectedConditions.elementToBeClickable(removeButton));
		
		WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@label='blah']")));
		checkBox.click();
		removeButton.click();
		
		WebElement add = driver.findElement(By.xpath("//button[text()='Add']"));
	//	Assert.assertEquals("//button[text()='Add']",add);
		wait.until(ExpectedConditions.elementToBeClickable(add));
		Assert.assertEquals("//p[@id='message']", "It's gone!");
}
}
