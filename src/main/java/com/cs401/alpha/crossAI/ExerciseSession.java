package com.cs401.alpha.crossAI;

import java.util.ArrayList;

public class ExerciseSession {

	public ExerciseSession(Integer id, String date, String time, String name, ArrayList<String> userids,
			ArrayList<ExerciseTypes> exercisetypes) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.name = name;
		this.userids = userids;
		this.exercisetypes = exercisetypes;
	}

	private Integer id;
	private String date; // stores the date
	private String time; // time in 24 hour format
	private String name; // yoga, swim, etc

	ArrayList<String> userids = new ArrayList<String>(); // array of userids

	ArrayList<ExerciseTypes> exercisetypes = new ArrayList<ExerciseTypes>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getUserids() {
		return userids;
	}

	public void setUserids(ArrayList<String> userids) {
		this.userids = userids;
	}

	public ArrayList<ExerciseTypes> getExercisetypes() {
		return exercisetypes;
	}

	public void setExercisetypes(ArrayList<ExerciseTypes> exercisetypes) {
		this.exercisetypes = exercisetypes;
	}

	@Override
	public String toString() {
		return "ExerciseSession [id=" + id + ", date=" + date + ", time=" + time + ", name=" + name + "]";
	}

}
