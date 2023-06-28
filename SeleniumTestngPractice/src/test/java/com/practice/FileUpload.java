package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Widgets");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}

	@Test
	public void fileUpload() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='image_file']"))
				.sendKeys("C:\\Users\\PratikshaP\\Desktop\\exception.png");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='button']")).click();

	}
	@AfterTest
	public void tearDown() {
		driver.quit();

	}
	
	
	

}
