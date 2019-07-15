package com.cs401.alpha.crossAI;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class UserHistoRel {

	public void saveInHistoAndRelTable(org.json.simple.JSONObject joo, String[] userIds, String jsonString) {
		System.out.println("inside saveInHistoAndRelTable");

		int histId = (int) joo.get("id");
		System.out.println(histId);

		// String[] userIds = (String[]) joo.get("userids");

		System.out.println(userIds);

		String dt = (String) joo.get("date");
		System.out.println(joo.get("date"));

		String tm = (String) joo.get("time");
		System.out.println(joo.get("time"));

		String nm = (String) joo.get("name");
		System.out.println(joo.get("name"));

		// Blob bb = joo;
		System.out.println(joo.get("exercisetypes"));

		try {
			// create a mysql database connection
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

	public ArrayList<String> query4mRel4Userid(String uid) {
		// TODO return all dates/exercises from histo table based on histid

		return null;

	}

	public JSONObject query4mHisto4Date(String date) {

		return null;
	}

}
