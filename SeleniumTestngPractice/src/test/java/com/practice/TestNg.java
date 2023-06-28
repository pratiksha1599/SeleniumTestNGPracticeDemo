package com.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestNg {


	WebDriver driver = null;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().browserVersion("97.0.4692.99").setup();
		driver = new ChromeDriver();
		 //driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	@Test
    public void loginTest() {
		driver.get("https://www.google.com/");
		
	     driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.name("q")).sendKeys("w3school");
	    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	
	Actions action = new Actions(driver);
	action.click(driver.findElement(By.xpath(" //h3[contains(text(),'W3Schools Online Web Tutorials')]")))
	.build().perform();
	}
    
	@Test
	public void DropDownTest() {
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.uitestpractice.com/Students/Select");
		driver.findElement(By.xpath("//select[@id='countriesSingle']")).click();
		WebElement dropdonOption = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/select[1]/option[1]"));
		// select[@id='countriesSingle']//option[@value='India'][contains(text(),'India')]
		System.out.println(dropdonOption.getText());

	}
	@Test
	public void optOnTable() throws InterruptedException  {
		
		WebDriverManager.chromedriver().browserVersion(" 97.0.4692.99 ").setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
		driver.findElement(By.xpath("//input[@id='task-table-filter']")).sendKeys("4");
		
	Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@id='task-table-filter']")).sendKeys("	John Smith");
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-filter']")).click();
		driver.findElement(By.xpath("//body/div[@class='container-fluid text-center']/div[@class='row']/div[@class='col-md-6 text-left']/div[@class='row']/div[@class='panel panel-primary filterable']/table[@class='table']/thead/tr[@class='filters']/th[1]/input[1]")).sendKeys("2");
		Thread.sleep(5000);	
		}
	@Test
	public void navigate() throws InterruptedException {
		driver.navigate().to("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		driver.findElement(By.name("q")).sendKeys("rahulshetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		// for opening in new tab
		String currentHandle = driver.getWindowHandle();
		String urlToClick = driver.findElement(By.xpath("//div[@class='TbwUpd NJjxre']//cite[@class='iUh30 tjvcx']"))
				.getText();

//		

		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open()");

		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {

			if (!actual.equalsIgnoreCase(currentHandle)) {
				// switching to the opened tab
				driver.switchTo().window(actual);

				// opening the URL saved.
				driver.get(urlToClick);

			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//header[1]/div[2]/div[1]/div[1]/div[2]/div[2]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().refresh();
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();

	}
	
	
	
	
}
