package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBase1 {
           @Test
        public void insertdata() throws ClassNotFoundException{
		
		

		 {
		// Step 1. Register driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Step 2. create connection
		try {
		Connection con = DriverManager.getConnection(
		"jdbc:sqlserver://IMCCBCP291-MSL2\\SQLEXPRESS2019;databaseName=Testcase;user=sa;password=Password_123");
		System.out.println("database is connected");
		
		
		
		
		PreparedStatement stmt = con.prepareStatement(" insert into testr values(?,?,?,?,?,?,?,?,?)");
		
		
		
		stmt.setString(1,"mee");
		stmt.setString(2,"sara");
		stmt.setString(3,"y");
		stmt.setString(4,"cricket");
		stmt.setString(5,"india");
		stmt.setString(6,"01/01/2000");
		stmt.setInt(7,897889);
		stmt.setString(8,"ppp");
		stmt.setString(9,"my name");
	
		int i=stmt.executeUpdate();



		System.out.println(i+"records inserted");
		
		
		
		con.close();
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		
		
		
		}
		}
	// IMCCBCP291-MSL2\SQLEXPRESS2019
			
		

	}

	}


