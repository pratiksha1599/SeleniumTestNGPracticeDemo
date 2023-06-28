package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	WebDriver driver = null;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().browserVersion("97.0.4692.99").setup();
		driver = new ChromeDriver();
		//driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

	}

	@Test()
	public void loginTest()

	{

//		WebDriverManager.chromedriver().browserVersion("97.0.4692.99").setup();
//		driver = new ChromeDriver();
//		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
//
//		List<WebElement> checkbox = driver
//				.findElements(By.xpath("//div[@class='container']//label[@class='checkbox-inline']//input[1]"));
//
//
//		System.out.println(checkbox.size());
//
//		for (WebElement element : checkbox) {
//			System.out.println(element.isSelected());
//			System.out.println(element.getAttribute("value"));
//			if (element.getAttribute("value").equals("dance") || element.getAttribute("value").equals("cricket")) {
//				element.click();
//			}
//		}
//
//		System.out.println("++++++++++++++");
//		for (WebElement e : checkbox) {
//			System.out.println(e.isSelected());
//		}

		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://ctonlinetest.citiustech.com/login/index.php");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#username")).sendKeys("pratiksha.patil@citiustech.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("pratikshapatil");
		driver.findElement(By.cssSelector("#loginbtn")).click();

	}

	@Test()
	public void DropDownTest() {
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.uitestpractice.com/Students/Select");
		driver.findElement(By.xpath("//select[@id='countriesSingle']")).click();
		WebElement dropdonOption = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/select[1]/option[1]"));
		// select[@id='countriesSingle']//option[@value='India'][contains(text(),'India')]
		System.out.println(dropdonOption.getText());

	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}
}