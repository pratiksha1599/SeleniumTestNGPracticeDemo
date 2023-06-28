package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {
	WebDriver driver = null;

	@Test
	public void name() {
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("pratiksha");
		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
	}

	@Test
	public void addition() {
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
		driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys("1");
		driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();
	}

	@Test
	public void getdata() throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion("97.0.4692.99").setup();
		driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
		WebElement element = driver.findElement(By
				.xpath("//body/div[@id='easycont']/div[@class='row']/div[@class='col-md-6 text-left']/div[2]/div[2]"));
		System.out.println(element.getText());
		Thread.sleep(5000);
		driver.close();

	}
}
