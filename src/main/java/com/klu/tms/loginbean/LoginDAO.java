package com.klu.tms.loginbean;

import java.sql.*;

import com.klu.tms.connection.DataConnect;

public class LoginDAO {
	public static boolean validate(String email, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			System.out.print("Your password is:"+password);
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select email, password from vsignup where email = ? and password = ? ");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
}