package com.agjsj.entity;

/**
 * Trainreplay entity. @author MyEclipse Persistence Tools
 */

public class Trainreplay implements java.io.Serializable {

	// Fields

	private Integer trainreplayId;
	private Integer trainId;
	private Integer userId;
	private String userName;
	private String userIcon;
	private String trainreplayContext;
	private String trainreplayTime;

	// Constructors

	/** default constructor */
	public Trainreplay() {
	}

	/** full constructor */
	public Trainreplay(Integer trainId, Integer userId, String userName,
			String trainreplayContext, String trainreplayTime) {
		this.trainId = trainId;
		this.userId = userId;
		this.userName = userName;
		this.trainreplayContext = trainreplayContext;
		this.trainreplayTime = trainreplayTime;
	}

	// Property accessors

	public Integer getTrainreplayId() {
		return this.trainreplayId;
	}

	public void setTrainreplayId(Integer trainreplayId) {
		this.trainreplayId = trainreplayId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
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

	public String getTrainreplayContext() {
		return this.trainreplayContext;
	}

	public void setTrainreplayContext(String trainreplayContext) {
		this.trainreplayContext = trainreplayContext;
	}

	public String getTrainreplayTime() {
		return this.trainreplayTime;
	}

	public void setTrainreplayTime(String trainreplayTime) {
		this.trainreplayTime = trainreplayTime;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	

}