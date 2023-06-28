package com.login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login1 {

	@Test
	public void testlogin()
	{
	//LoginPage login=new LoginPage();
	System.out.println("hello");
	//WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebDriverManager.chromedriver().browserVersion("98.0.4758.82").setup();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
	
	
}
}
