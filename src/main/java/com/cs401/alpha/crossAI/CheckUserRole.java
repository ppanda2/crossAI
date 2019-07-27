package com.cs401.alpha.crossAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckUserRole {

	public String CheckUser(String userId, String password) throws SQLException {

		String myUrl = "jdbc:mysql://localhost:3306/alphadb";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * FROM alphadb.user where userId =" + "\"" + userId + "\"" + "and password = " + "\""
				+ password + "\"";

		System.out.println(query); // create the java statement
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(rs);

		if (rs.next()) {
			System.out.println("one record exists");
			String relquery = "SELECT roleId FROM alphadb.user_role_rel where userId =" + "\"" + userId + "\"";
			System.out.println(relquery);
			st = null;
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			rs = null;
			try {
				rs = st.executeQuery(relquery);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (rs.next()) {

				String temprole = rs.getString(1);

				System.out.println(temprole);

				String rolequery = "SELECT roleName FROM alphadb.role where roleId =" + temprole;

				st = null;
				try {
					st = conn.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				rs = null;
				try {
					rs = st.executeQuery(rolequery);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (rs.next()) {
					System.out.println(rs);
					System.out.println(rs.getString(1));

					if (rs.getString(1).equals("Admin"))
						return "yesAdmin";
					else
						return "NoAdmin";
				}
			} else {
				return "NoAdmin";
			}
		}

		else {
			return "UserDoesNotExist";
		}
		return "defaultUserDoesNotExist";
	}
}
