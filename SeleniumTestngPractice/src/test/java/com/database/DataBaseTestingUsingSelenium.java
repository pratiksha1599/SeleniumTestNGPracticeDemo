package com.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTestingUsingSelenium {

	@Test
	public void databaseTest() throws InterruptedException, ClassNotFoundException
	{
		
		WebDriverManager.chromedriver().browserVersion("97.0.4692.99").setup();



		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Form");
		//driver.findElement(By.xpath("//a[contains(text(),'Form')]"));



		// this is going to maximize the size of the web browser
		driver.manage().window().maximize();



		// this will keep our window active for this much of seconds
		// we can use this method insted of thread.sleep
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));

		//Entering value in firstname
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("pratiksha");

		//Entering value in lastname
		driver.findElement(By.cssSelector("#lastname")).sendKeys("patil");

		//Selecting radio button
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[3]/label[3]/input[1]")).click();

		//Selecting checkbox
		List<WebElement> checkbox=driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[4]/label[@class='checkbox-inline']/input[2]"));
		//System.out.println(checkbox.size());

		//Selecting checkbox using for and if
		for (WebElement element : checkbox) {

		//System.out.println(element.isSelected());
		//System.out.println(element.getAttribute("value"));

		if (element.getAttribute("value").equals("dance") || element.getAttribute("value").equals("cricket")) {
		element.click();
		}
		}

		//used for reach to the drop-down
		WebElement elements=driver.findElement(By.id("sel1"));
		Select sel=new Select(elements);

		//For select Drop-down
		sel.selectByVisibleText("India");

		//For DateOfBirth
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("1/1/2000");

		//For PhoneNumber
		driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("9999999999");

		//For username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Pratiksha");

		//For email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("LaxmiG@gmail.com");

		//For TextArea
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("I am Fresher");

		//For password
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Laxmi@123");
		Thread.sleep(5000);

		//For Submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//For close the browser
		
		
		String firstname = "pratiksha";
		String lastname = "pratiksha";
         String dob = "1/1/2000";
     	long  phno = 9999999999l;
        String username = "Pratiksha";
		Connection con = null;
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Register");
			
			con=DriverManager.getConnection("jdbc:sqlserver://IMCCBCP289-MSL2\\SQLEXPRESS2019;databaseName=Testing;user=sa;password=Password_123");
			System.out.println("database connected");
//			PreparedStatement stmt = con.prepareStatement(" insert into testing_table values(?,?,?,?,?,?,?,?,?)");
//			stmt.setString(1, "pratiksha");
//			stmt.setString(2, "patil");
//			
//			stmt.setInt(0, 0);
			
			String sqlQuery = "select FirstName,LastName,DOB,PNumber,UserName from testing_table order By username desc Limit 1";
			
			Statement statement = con.createStatement();
			//Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			rs.next();
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("lastname"));
			System.out.println(rs.getString("dob"));
		    System.out.println(rs.getString("phno"));
		    System.out.println(rs.getString("username"));
			
		    
		    
		    
		  //Database testing
			
			if(rs.getString("FirstName").equals(firstname))
				System.out.println("First name is not correct");
			if(rs.getString("LastName").equals(lastname))
                System.out.println("Last name is not correct");
             if(rs.getString("DOB").equals(dob))
             System.out.println("DOB is not correct");
             if(rs.getString("UserName").equals(username))
                 System.out.println("username name is not correct");
		}
		catch(SQLException e) {
			
			System.out.println("database is not connected");
		}

		
		
		
		driver.quit();

		}

}
	
	
	
	
	
	
	
	
	
	
	


