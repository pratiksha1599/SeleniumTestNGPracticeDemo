package com.dataProvider;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterWithMultipleTestCases {

	@Test(dataProviderClass = DataProviderEx.class, dataProvider = "data")
	public void login(String username, String password) {
		
		
		System.out.println("-----login-------");
		System.out.println(username);
		System.out.println( password);
		

	}

	@Test(dataProviderClass = DataProviderEx.class, dataProvider = "data")
	public void registration(String username, String password, String email, String address) {
		System.out.println("-----registarion -------");
		System.out.println( username);
		System.out.println(password);
		System.out.println(email);
		System.out.println(address);
		
	}

}
