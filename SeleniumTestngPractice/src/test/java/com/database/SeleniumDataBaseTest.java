package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class SeleniumDataBaseTest {

	//public static void main(String[] args) {
		
	Connection con = null;
		
		@Test
		public void SeleniumDataBaseTesting() throws ClassNotFoundException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		try {
			
			
			//System.out.println("Driver Register");
			
			con=DriverManager.getConnection("jdbc:sqlserver://IMCCBCP289-MSL2\\SQLEXPRESS2019;databaseName=Testing;user=sa;password=Password_123");
			System.out.println("database connected");
//			PreparedStatement stmt = con.prepareStatement(" insert into testing_table values(?,?,?,?,?,?,?,?,?)");
//			stmt.setString(1, "pratiksha");
//			stmt.setString(2, "patil");
			
			// IMCCBCP291-MSL2\SQLEXPRESS2019
			
		}
		catch(SQLException e) {
			
			System.out.println("database is not connected");
		}

	}

}

// IMCCBCP291-MSL2\SQLEXPRESS2019   new one
// jdbc:sqlserver://IMCCBCP289-MSL2\\\\SQLEXPRESS2019 earlier