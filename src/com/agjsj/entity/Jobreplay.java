package com.agjsj.entity;

/**
 * Jobreplay entity. @author MyEclipse Persistence Tools
 */

public class Jobreplay implements java.io.Serializable {

	// Fields

	private Integer jobreplayId;
	private Integer jobId;
	private Integer userId;
	private String usericon;
	private String userName;
	private String jobreplayContext;
	private String jobreplayTime;

	// Constructors

	/** default constructor */
	public Jobreplay() {
	}

	/** full constructor */
	public Jobreplay(Integer jobId, Integer userId, String userName,
			String jobreplayContext, String jobreplayTime) {
		this.jobId = jobId;
		this.userId = userId;
		this.userName = userName;
		this.jobreplayContext = jobreplayContext;
		this.jobreplayTime = jobreplayTime;
	}

	// Property accessors

	public Integer getJobreplayId() {
		return this.jobreplayId;
	}

	public void setJobreplayId(Integer jobreplayId) {
		this.jobreplayId = jobreplayId;
	}

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobreplayContext() {
		return this.jobreplayContext;
	}

	public void setJobreplayContext(String jobreplayContext) {
		this.jobreplayContext = jobreplayContext;
	}

	public String getJobreplayTime() {
		return this.jobreplayTime;
	}

	public void setJobreplayTime(String jobreplayTime) {
		this.jobreplayTime = jobreplayTime;
	}

	public String getUsericon() {
		return usericon;
	}

	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	

}