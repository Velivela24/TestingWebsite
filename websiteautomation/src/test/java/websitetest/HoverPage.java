package websitetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverPage {
	@Test
	public void hoverTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/");
		WebElement hoverEle = driver.findElement(By.xpath("//a[text()='Hovers']"));
		hoverEle.click();
		WebElement titleEle = driver.findElement(By.xpath("//h3[text()='Hovers']"));
		String heading = titleEle.getText();
		Assert.assertEquals(heading, "Hovers");

		// driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
		// Assert.assertEquals(heading, "Elemental Selenium");
		// driver.navigate().back();
        
	}

}
