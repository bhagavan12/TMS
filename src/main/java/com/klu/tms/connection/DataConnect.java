package com.klu.tms.connection;

import java.sql.*;

public class DataConnect {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ep_sec02", "root", "Klu173017*");
			return con;
		} catch (Exception ex){
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}

	public static void close(ResultSet resultSet) {
		// TODO Auto-generated method stub
		
	}

	public static void close(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}
}