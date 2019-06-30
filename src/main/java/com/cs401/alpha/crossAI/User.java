package com.cs401.alpha.crossAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;



@Entity
public class User {
	
	@Id
	private String userId;

	private String firstName;

	private String lastName;

	public String getUserId() {
		return userId;
	}

	public User() {

	}

	public User(String userId, String firstname, String lastName) {
		this.userId = userId;
		this.firstName = firstname;
		this.lastName = lastName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + userId + ", FirstName='" + firstName + '\'' + ", LastName='" + lastName + '\'' + '}';
	}
	
	/*public  User findauser(String uid) {
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		//EntityManager em = emf.createEntityManager();
		System.out.println("he ha = "+ uid);
	
		System.out.println("uid = "+ uid);
		
		User u = ur.findAllByUserID(uid);
		
		System.out.println(u);
		
		return u ;
		
	}*/

	/*public String getFirstName(String id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		// String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/alphadb";

		Connection conn = DriverManager.getConnection(myUrl, "root", "root");

		// our SQL SELECT query.
		// if you only need a few columns, specify them by name instead of using "*"
		String query = "SELECT * FROM alphadb.user where userId = 'user1'";// + id ;

		System.out.println(query);
		// create the java statement
		Statement st = conn.createStatement();

		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);
		rs.next();
		// while(rs.next())
		// {
		System.out.println(rs.getString("firstName"));
		// }

		return rs.getString("firstName");

	}*/

}
