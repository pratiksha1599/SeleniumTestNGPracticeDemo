package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DualBoxSearch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
		
		 driver.get("https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");
		  
		 driver.findElement(By.xpath("//a[@class='btn btn-default selector']")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-right']")).click();
		 Thread.sleep(1000);
		 
		 
		 driver.findElement(By.xpath("//a[@class='btn btn-default selector selected']")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("	//button[@class='btn btn-default btn-sm move-left']")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.name("SearchDualList")).sendKeys("Vestibulum at eros");
		 driver.findElement(By.xpath("	//button[@class='btn btn-default btn-sm move-right']")).click();
		 
		 
		 
		 // //div[@class='well']//div[@id='listhead']//div[@class='col-md-10']//div[@class='input-group']//input[@type='text']
		  
		 driver.findElement(By.name("SearchDualList")).sendKeys("Morbi leo risus");
		 driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-left']")).click();
		 
		 System.out.println("its done");
	
	
	}

}
