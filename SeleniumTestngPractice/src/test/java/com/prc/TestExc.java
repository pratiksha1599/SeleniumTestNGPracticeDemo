package com.prc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumchromedriver\\chromedriver.exe");
		// WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//input[@id='image_file']"))
				.sendKeys("C:\\Users\\PratikshaP\\Desktop\\exception.png");
		driver.findElement(By.xpath("//input[@type='button']")).click();

	}

}
