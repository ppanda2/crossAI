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

	private Date dateTime;

	private String exerciseName;

	private JSONObject exercise;

	@ManyToMany
	@JoinTable(name = "user_hist_rel", joinColumns = @JoinColumn(name = "histid"), inverseJoinColumns = @JoinColumn(name = "userid"))

	Set<User> participates;

	public Integer getHistId() {
		return histId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public JSONObject getExercise() {
		return exercise;
	}

	public Set<User> getParticipates() {
		return participates;
	}

	public void setHistId(Integer histId) {
		this.histId = histId;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

}
