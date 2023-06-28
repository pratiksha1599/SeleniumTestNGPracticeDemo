package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class TablePagination {

	public void paginationTable() {
		WebDriverManager.firefoxdriver().browserVersion("96.0.3 ").setup();
		WebDriver driver = new FirefoxDriver();
	  driver.get("https://demo.seleniumeasy.com/table-pagination-demo.html");
	  
	  int paginationSize = driver.findElements(By.cssSelector("#>myPager>a")).size();
	// a.active   
	
	 // div.container-fluid.text-center:nth-child(2) div.row div.col-md-6.text-left:nth-child(2) div.col-md-6.text-center:nth-child(6) ul.pagination.pagination-lg.pager li.active:nth-child(2) > a.page_link.active
	  
	  
	  
	  List<String> names = new ArrayList<String>();
	  // a.active
	  for(int i=1;i<=paginationSize;i++)
	  {
		  
	  }
	}
}
