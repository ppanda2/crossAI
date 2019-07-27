package com.cs401.alpha.crossAI;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userid;
	private String feedbac;
	private String score;
	private String datetime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getFeedback() {
		return feedbac;
	}
	public void setFeedback(String feedback) {
		this.feedbac = feedback;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public Feedback(String userid, String datetime, String feed, String score) {
		this.userid = userid;
		this.datetime = datetime;
		this.feedbac = feed;
		this.score = score;
	}
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userid=" + userid + ", feedbac=" + feedbac + ", score=" + score + ", datetime="
				+ datetime + "]";
	}
}
