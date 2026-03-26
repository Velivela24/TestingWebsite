package websitetest;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDown {

	@Test
	public void dropDownTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/");
		WebElement dropDownEle = driver.findElement(By.xpath("//a[text()='Dropdown']"));
		dropDownEle.click();

		WebElement dropDownHeading = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
		String Heading = dropDownHeading.getText();
		Assert.assertEquals(Heading, "Dropdown List");
	WebElement dropDown =driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dd = new Select(dropDown);
		dd.selectByVisibleText("Option 2");
		//dd.selectByIndex(2);
		//dd.selectByValue("2");
	}

}
