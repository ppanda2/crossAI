package com.cs401.alpha.crossAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;

@Entity
public class User {

	@Id
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	

	private String age;
	private String gender;
	private String email;
	private String phone;
	private String weight;
	private String fat;
	private String height;
	
	private String bmi;
	private String fitscore;
	private String goal;
	private String status;

	@ManyToMany(mappedBy = "participates")
	Set<Histo> participatedClasses;

	public User() {

	}

	public User(String userId, String firstname, String lastName) {
		this.userId = userId;
		this.firstName = firstname;
		this.lastName = lastName;
	}

	public User(String userId, String password, String firstName, String lastName, String age, String gender,
			String email, String phone, String weight, String fat, String height, String bmi, String fitscore, String goal,
			String status) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.weight = weight;
		this.fat = fat;
		this.height = height;
		this.bmi = bmi;
		this.fitscore = fitscore;
		this.goal = goal;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getFat() {
		return fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getFitscore() {
		return fitscore;
	}

	public void setFitscore(String fitscore) {
		this.fitscore = fitscore;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", weight=" + weight + ", fat=" + fat + ", height=" + height + ", bmi=" + bmi + ", fitscore="
				+ fitscore + ", goal=" + goal + ", status=" + status + "]";
	}

	public Set<Histo> getParticipatedClasses() {
		return participatedClasses;
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
