package com.cs401.alpha.crossAI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class exercise {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idexercise;
	

    private String exercise;

    private String exercisedesc;

	public Integer getIdexcercise() {
		return idexercise;
	}

	public void setIdexcercise(Integer idexcercise) {
		this.idexercise = idexcercise;
	}

	public String getExcercise() {
		return exercise;
	}

	public void setExcercise(String excercise) {
		this.exercise = excercise;
	}

	public String getExcercisedesc() {
		return exercisedesc;
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
