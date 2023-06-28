package com.practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {

	@BeforeMethod
	public void setUp() {
		System.out.println("Before method start up initialization");
	}
	@Test
	public void doFirstTest() {
		System.out.println("First test Case");
	}
	@Test
	public void doSeondTest() {
		System.out.println("Second test Case");
	
 }
	@AfterMethod
	public void tearDown() {
		System.out.println("Before Method close the resources");
	}
}
