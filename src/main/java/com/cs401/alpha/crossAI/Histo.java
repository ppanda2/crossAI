package com.cs401.alpha.crossAI;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.json.simple.JSONObject;

@Entity
public class Histo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer histId;
	private String date;
	private String time;
	private String exerciseName;
	private String exercise;

	@ManyToMany
	@JoinTable(name = "user_hist_rel", joinColumns = @JoinColumn(name = "histid"), inverseJoinColumns = @JoinColumn(name = "userid"))

	Set<User> participates;

	public Histo(String date, String time, String exerciseName, String exercise) {
		super();
		this.date = date;
		this.time = time;
		this.exerciseName = exerciseName;
		this.exercise = exercise;
	}

	public Integer getHistId() {
		return histId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public String getExercise() {
		return exercise;
	}

	public Set<User> getParticipates() {
		return participates;
	}

	public void setHistId(Integer histId) {
		this.histId = histId;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
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

	@Override
	public String toString() {
		return "Histo [histId=" + histId + ", date=" + date + ", time=" + time + ", exerciseName=" + exerciseName
				+ ", exercise=" + exercise + ", participates=" + participates + "]";
	}

}
