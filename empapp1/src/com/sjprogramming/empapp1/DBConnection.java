package com.sjprogramming.empapp1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con;

	public static Connection createDBConnection() {

		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/employeedb?useSSL=false";
			String username = "root";
			String password = "Snehal@101";
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
