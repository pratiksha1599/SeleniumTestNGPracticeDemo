package com.dataProvider;



import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderEx {
	@DataProvider(name="data")
	public Object[][] diffTestParameter(Method m) {
		Object[][] obj = null;
		if (m.getName().equalsIgnoreCase("login")) {

			obj = new Object[5][2];

			obj[0][0] = "punam";
			obj[0][1] = "punam@123";

			obj[1][0] = "amruta";
			obj[1][1] = "amruta@123";

			obj[2][0] = "mayur";
			obj[2][1] = "mayur$123";

			obj[3][0] = "Abhi";
			obj[3][1] = "Abhi@123";

			obj[4][0] = "shree";
			obj[4][1] = "shree#123";
			
			return obj;
		} else if (m.getName().equalsIgnoreCase("registration")) {

			obj = new Object[5][4];
			obj[0][0] = "Kiran";
			obj[0][1] = "Kiran6";
			obj[0][2] = "Kiran@gmail.com";
			obj[0][3] = "Sangli";

			obj[1][0] = "nisha";
			obj[1][1] = "nisha123";
			obj[1][2] = "nisha@gmail.com";
			obj[1][3] = "satara";

			obj[2][0] = "priya";
			obj[2][1] = "priya123";
			obj[2][2] = "priya@gmail.com";
			obj[2][3] = "mumbai";

			obj[3][0] = "pravin";
			obj[3][1] = "Pravin2";
			obj[3][2] = "pravin@gmail.com";
			obj[3][3] = "Mumbai";

			obj[4][0] = "tushar";
			obj[4][1] = "tushar9";
			obj[4][2] = "tushar@gmail.com";
			obj[4][3] = "Thane";

		}
		return obj;
	}
}
