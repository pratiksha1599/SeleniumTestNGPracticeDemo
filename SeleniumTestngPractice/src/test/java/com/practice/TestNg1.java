package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg1 {

	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		  driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}

	@Test
	public void searchData() {
//		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        String name = driver.findElement(By.xpath("//td[@data-search='Tiger Nixon']")).getText();
		System.out.println(name);

		String table = driver.findElement(By.xpath("//table//tr//td")).getText();
		System.out.println("table data" + table);

		String position = driver.findElement(By.xpath(
				"//body/div[@class='container-fluid text-center']/div[@class='row']/div[@class='col-md-6 text-left']/div[@class='row']/table[@id='example']/tbody/tr[13]/td[2]"))
				.getText();
		System.out.println("position" + position);

		String office = driver.findElement(By.xpath(
				"//body/div[@class='container-fluid text-center']/div[@class='row']/div[@class='col-md-6 text-left']/div[@class='row']/table[@id='example']/tbody/tr[8]/td[3]"))
				.getText();
		System.out.println("office" + office);

	}

	@Test
	public void pagination() throws InterruptedException {
		driver.get("https://demo.seleniumeasy.com/table-pagination-demo.html#");

		// click on 1
		driver.findElement(By.xpath("//a[@class='page_link active']")).click();
		Thread.sleep(5000);
		String page1 = driver.findElement(By.className("content")).getText();
		System.out.println(page1);

		// click on next button
		driver.findElement(By.xpath("//a[@class='next_link']")).click();
		Thread.sleep(5000);
		String page2 = driver.findElement(By.className("content")).getText();
		System.out.println(page2);

		// click on next button
		driver.findElement(By.xpath("//a[@class='page_link'][contains(text(),'3')]")).click();
		Thread.sleep(5000);
		String page3 = driver.findElement(By.className("content")).getText();
		System.out.println(page3);
	}

	@Test
	public void dualBoxSearch() throws InterruptedException {

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

		Thread.sleep(1000);
		// //div[@class='well']//div[@id='listhead']//div[@class='col-md-10']//div[@class='input-group']//input[@type='text']

		driver.findElement(By.name("SearchDualList")).sendKeys("Morbi leo risus");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-left']")).click();
		System.out.println("its done");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
