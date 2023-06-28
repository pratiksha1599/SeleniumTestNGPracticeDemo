package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchData {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
	  driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
	  
	String name=  driver.findElement(By.xpath("//td[@data-search='Tiger Nixon']")).getText();
	System.out.println(name);
	}

}
