package com.cs401.alpha.crossAI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idexercise;
	private String exercise;
	private String exercisedesc;

	public Exercise(String exercise, String exercisedesc) {
		this.exercise = exercise;
		this.exercisedesc = exercisedesc;
	}

	public void setIdexcercise(Integer idexcercise) {
		this.idexercise = idexcercise;
	}

	public void setExcercise(String excercise) {
		this.exercise = excercise;
	}

	public String getExcercisedesc() {
		return exercisedesc;
	}

	public Integer getIdexcercise() {
		return idexercise;
	}

	public String getExcercise() {
		return exercise;
	}

	public void setExcercisedesc(String excercisedesc) {
		this.exercisedesc = excercisedesc;
	}

	@Override
	public String toString() {
		return "Excercise [idexcercise=" + idexercise + ", excercise=" + exercise + ", excercisedesc=" + exercisedesc
				+ "]";
	}
}
