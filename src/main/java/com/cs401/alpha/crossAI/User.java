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
	private int age;
	private String gender;
	private String email;
	private String phone;
	private int weight;
	private long fat;
	private int height;
	private long bmi;
	private long fitscore;
	private int goal;
	private String status;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getFat() {
		return fat;
	}

	public void setFat(long fat) {
		this.fat = fat;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getBmi() {
		return bmi;
	}

	public void setBmi(long bmi) {
		this.bmi = bmi;
	}

	public long getFitscore() {
		return fitscore;
	}

	public void setFitscore(long fitscore) {
		this.fitscore = fitscore;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * public User findauser(String uid) {
	 * 
	 * //EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
	 * //EntityManager em = emf.createEntityManager();
	 * System.out.println("he ha = "+ uid);
	 * 
	 * System.out.println("uid = "+ uid);
	 * 
	 * User u = ur.findAllByUserID(uid);
	 * 
	 * System.out.println(u);
	 * 
	 * return u ;
	 * 
	 * }
	 */

	/*
	 * public String getFirstName(String id) throws ClassNotFoundException,
	 * SQLException {
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver"); // String myDriver =
	 * "org.gjt.mm.mysql.Driver"; String myUrl =
	 * "jdbc:mysql://localhost:3306/alphadb";
	 * 
	 * Connection conn = DriverManager.getConnection(myUrl, "root", "root");
	 * 
	 * // our SQL SELECT query. // if you only need a few columns, specify them by
	 * name instead of using "*" String query =
	 * "SELECT * FROM alphadb.user where userId = 'user1'";// + id ;
	 * 
	 * System.out.println(query); // create the java statement Statement st =
	 * conn.createStatement();
	 * 
	 * // execute the query, and get a java resultset ResultSet rs =
	 * st.executeQuery(query); rs.next(); // while(rs.next()) // {
	 * System.out.println(rs.getString("firstName")); // }
	 * 
	 * return rs.getString("firstName");
	 * 
	 * }
	 */

}
