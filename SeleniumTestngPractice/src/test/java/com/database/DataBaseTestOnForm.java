package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTestOnForm {

	String firstname = "pratiksha";
	String lastname = "patil";
	String dob = "1/1/2000";
	int phno = 999999;
	String username = "Pratiksha";
	Connection con = null;

	@Test
	public void databaseTest() throws InterruptedException, ClassNotFoundException {
		
		 ExtentReports extent = new ExtentReports();
	        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	        extent.attachReporter(spark);

			
			  extent.createTest("ScreenCapture") .addScreenCaptureFromPath("failed.png")
			  .pass(MediaEntityBuilder.createScreenCaptureFromPath("failed.png").build());

		WebDriverManager.chromedriver().browserVersion("97.0.4692.99").setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Form");
		// driver.findElement(By.xpath("//a[contains(text(),'Form')]"));

		// this is going to maximize the size of the web browser
		driver.manage().window().maximize();

		// this will keep our window active for this much of seconds
		// we can use this method insted of thread.sleep
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));

		// Firstname
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("pratiksha");
		Thread.sleep(2000);
		// Lastname
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("patil");
		Thread.sleep(2000);
		WebElement radio = driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[3]/label[3]"));

		radio.click();
		Thread.sleep(2000);

		// cheakbox

		List<WebElement> checkbox = driver.findElements(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[4]/label[@class='checkbox-inline']/input[1]"));

		System.out.println(checkbox.size());

		for (WebElement element : checkbox) {
			System.out.println(element.isSelected());
			System.out.println(element.getAttribute("value"));
			if (element.getAttribute("value").equals("dance") || element.getAttribute("value").equals("cricket")) {
				element.click();
			}
		}

		for (WebElement e : checkbox) {
			System.out.println(e.isSelected());
		}
		Thread.sleep(2000);
		WebElement dropdonoption = driver.findElement(By.xpath("//option[contains(text(),'India')]"));
		System.out.println(dropdonoption.getText());
		Thread.sleep(2000);
		//// option[contains(text(),'India')]
		// driver.findElement(By.xpath("//select[@id='sel1']")).sendKeys("India");
		// Date of Birth
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("1/1/2000");
		Thread.sleep(2000);
		// phonenumber
		driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("999999");
		Thread.sleep(2000);
		// username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Pratiksha");
		Thread.sleep(2000);
		//
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pratikshap09@gmail.com");
		Thread.sleep(2000);
		//
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("I am fresher");
		Thread.sleep(2000);
		// password
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Pr@tiksha09");
		Thread.sleep(2000);
		//
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}
		// For close the browser

//		String firstname = "pratiksha";
//		String lastname = "patil";
//         String dob = "1/1/2000";
//         int phno = 999999;
//        String username = "Pratiksha";

		//Connection con = null;

//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
	@Test
	public void test_case2() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCCBCP291-MSL2\\SQLEXPRESS2019;databaseName=Testcase;user=sa;password=Password_123");
			System.out.println("database is connected");

			PreparedStatement stmt = con.prepareStatement(" insert into testr values(?,?,?,?,?,?,?,?,?)");
			
			
			
			stmt.setString(1,"mee");
			stmt.setString(2,"sara");
			stmt.setString(3,"single");
			stmt.setString(4,"cricket");
			stmt.setString(5,"india");
			stmt.setString(6,"01/01/2000");
			stmt.setInt(7,897889);
			stmt.setString(8,"ppp");
			stmt.setString(9,"my name");
		
			int i=stmt.executeUpdate();



			System.out.println(i+"records inserted");
//		    stmt.setString(1, "pratiksha");
//			stmt.setString(2, "patil");
			String sqlQuery = "select FirstName,LastName,DOB,PNumber,UserName from testing_table order By username desc Limit 1";

			Statement statement = con.createStatement();
			// Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
//			System.out.println("Hi");
//			rs.next();
//			System.out.println("hello");
//			System.out.println(rs.getString("firstname"));
//			System.out.println(rs.getString("lastname"));
//			System.out.println(rs.getString("dob"));
//			System.out.println(rs.getString("phno"));
//			System.out.println(rs.getString("username"));

			//// IMCCBCP291-MSL2\\SQLEXPRESS2019
			// IMCCBCP291-MSL2\SQLEXPRESS2019

			// Database testing
			while (rs.next()) {
				if (rs.getString("FirstName").equals(firstname))
					System.out.println("First name is not correct");
				if (rs.getString("LastName").equals(lastname))
					System.out.println("Last name is not correct");
				if (rs.getString("DOB").equals(dob))
					System.out.println("DOB is not correct");
				if (rs.getString("UserName").equals(username))
					System.out.println("username name is not correct");
				if(!rs.getString("FirstName").equals(firstname))
					System.out.println("extent.fail()");
				// con.close();
			}
		} catch (Exception e) {}

	
		//driver.quit();

	}
}
