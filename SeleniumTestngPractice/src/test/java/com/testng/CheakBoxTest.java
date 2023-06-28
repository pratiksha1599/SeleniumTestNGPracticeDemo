package com.testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheakBoxTest {

	WebDriver driver = null;
   @Test
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
   @Test
	public void performTestOnCheakBox() {
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();

		WebDriver driver = new FirefoxDriver();

		// WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Select");

		driver = new ChromeDriver();
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='display'][1]//input[@name='sports']"));
		System.out.println(checkbox.size());

		for (WebElement element : checkbox) {
			System.out.println(element.isSelected());
			System.out.println(element.getAttribute("value"));
			if (element.getAttribute("value").equals("Soccer") || element.getAttribute("value").equals("Baseball")) {
				element.click();
			}
		}
		System.out.println("**********************");
		for (WebElement e : checkbox) {
			System.out.println(e.isSelected());
		}

	}
   @Test
	public void testForDropDown() {
		driver.findElement(By.xpath("//select[@id='countriesSingle']")).click();

		WebElement dropdonoption = driver.findElement(
				By.xpath("//select[@id='countriesSingle']//option[@value='india'][contains(text(),'India')]"));
		System.out.println(dropdonoption.getText());
	}

	public void tearDown() {
		driver.close();
	}
}
