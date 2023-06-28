package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestForMultipleTestCases_backup {

	@Test(dataProvider = "testParameter")
	public void loginUser1(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		}
	
	
	
	
	
	
	}
