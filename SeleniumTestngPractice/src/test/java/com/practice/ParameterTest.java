package com.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	@Parameters({"username","password"})
	@Test
	
	public void login(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		}
	}
