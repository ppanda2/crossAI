package com.cs401.alpha.crossAI;

import java.util.ArrayList;

public class Types {

	private Integer duration;
	ArrayList<Exercise> Exercises = new ArrayList<Exercise>();

	public Types(Integer duration, ArrayList<Exercise> Exercises) {
		super();
		this.duration = duration;
		this.Exercises = Exercises;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ArrayList<Exercise> getExercises() {
		return Exercises;
	}

	public void setExercises(ArrayList<Exercise> Exercises) {
		this.Exercises = Exercises;
	}

	@Override
	public String toString() {
		return "Types [duration=" + duration + ", Exercises=" + Exercises + "]";
	}
}
