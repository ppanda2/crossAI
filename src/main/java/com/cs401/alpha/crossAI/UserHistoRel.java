package com.cs401.alpha.crossAI;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class UserHistoRel {

	public void saveInHistoAndRelTable(org.json.simple.JSONObject joo, String[] userIds, String jsonString) {
		System.out.println("inside saveInHistoAndRelTable");

		int histId = (int) joo.get("id");
		String dt = (String) joo.get("date");
		String tm = (String) joo.get("time");
		String nm = (String) joo.get("name");

		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/alphadb";

			Connection conn = null;
			try {
				conn = DriverManager.getConnection(myUrl, "root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("saving in histo table");

			String histoquery = "INSERT INTO `alphadb`.`histo` (`histId`, `date`, `time`, `exercise`, `exerciseName`)"
					+ " values (?, ?,?,?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(histoquery);
			System.out.println(histoquery); // create the java statement

			preparedStmt.setInt(1, histId);
			preparedStmt.setString(2, dt);
			preparedStmt.setString(3, tm);
			preparedStmt.setString(4, jsonString);
			preparedStmt.setString(5, nm);

			// execute the preparedstatement
			preparedStmt.execute();

			// create a sql date object so we can use it in our INSERT statement
			// Calendar calendar = Calendar.getInstance();
			// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			// the mysql insert statement

			System.out.println("saving in rel table");

			System.out.println(userIds.length);
			for (int i = 0; i < userIds.length; i++) {
				System.out.println("userids " + userIds[i]);

				String query = "INSERT INTO alphadb.user_hist_rel (histId, userid)" + " values (?, ?)";

				// create the mysql insert preparedstatement
				PreparedStatement prepStmt = conn.prepareStatement(query);
				System.out.println(query); // create the java statement

				prepStmt.setInt(1, histId);
				prepStmt.setString(2, userIds[i]);

				// execute the preparedstatement
				prepStmt.execute();
			}

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	public List<Histo> query4mRel4Userid(String uid) throws SQLException {

		System.out.println("query4mRel4Userid inside UserHistoRel.java");

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/alphadb";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "SELECT alphadb.histo.* FROM alphadb.user_hist_rel, alphadb.histo  where alphadb.user_hist_rel.userid ="
				+ "\"" + uid + "\"" + "and alphadb.user_hist_rel.histid  = alphadb.histo.histID";

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

		List<Histo> histdetails = new ArrayList<>();

		while (rs.next()) {
			System.out.println(rs.getString(2));
			histdetails.add(new Histo(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

		}

		return histdetails;

	}

	public JSONObject query4mHisto4Date(String date) {

		return null;
	}

}
