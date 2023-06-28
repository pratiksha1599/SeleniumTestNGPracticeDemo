package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class TestDataBase {

	Connection con = null;
	@Test
	public void SeleniumDataBaseTesting() throws ClassNotFoundException, SQLException {

//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCCBCP291-MSL2\\SQLEXPRESS2019;databaseName=Testcase;user=sa;password=Password_123");
			System.out.println("database is connected");
			
			PreparedStatement stmt = con.prepareStatement(" insert into testing_table values(?,?,?,?,?,?,?,?,?)");
		    stmt.setString(1, "Arti");
			stmt.setString(2, "pawar");
			stmt.setString(3, "yes");
			stmt.setString(4, "yes");
			stmt.setString(5, "Dancing");
			stmt.setString(6, "India");
			stmt.setString(7, "1/5/2000");
			stmt.setString(8, "Arati");
			stmt.setString(9, "hi");
		
			
			
			int i=stmt.executeUpdate();
			
			System.out.println(i+"records inserted");
			
			con.close();

		} catch (Exception e) {

		}

	}
}
// IMCCBCP291-MSL2\SQLEXPRESS2019