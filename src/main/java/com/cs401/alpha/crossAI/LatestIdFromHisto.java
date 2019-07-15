package com.cs401.alpha.crossAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LatestIdFromHisto {

	public int getid() throws SQLException {

		System.out.println("LatestIdFromHisto");

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/alphadb";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT histId FROM alphadb.histo order by histId desc  limit 1";

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int tempid =0;
		if (rs.next()) {
		tempid = rs.getInt(1);
		}
		System.out.println(tempid);

		return tempid +1;
	}

}
