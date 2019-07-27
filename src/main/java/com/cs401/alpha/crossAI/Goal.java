package com.cs401.alpha.crossAI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int goalId;

	private String goal;

	private String goalDesc;

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getGoalDesc() {
		return goalDesc;
	}

	public void setGoalDesc(String goalDesc) {
		this.goalDesc = goalDesc;
	}

	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", goal=" + goal + ", goalDesc=" + goalDesc + "]";
	}
}
