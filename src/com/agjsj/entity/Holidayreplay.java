package com.agjsj.entity;

/**
 * Holidayreplay entity. @author MyEclipse Persistence Tools
 */

public class Holidayreplay implements java.io.Serializable {

	// Fields

	private Integer holidayreplayId;
	private Integer holidayId;
	private Integer userId;
	private String userName;
	private String userIcon;
	private String holidayreplayContext;
	private String holidayreplayTime;

	// Constructors

	/** default constructor */
	public Holidayreplay() {
	}

	/** full constructor */
	public Holidayreplay(Integer holidayId, Integer userId, String userName,
			String holidayreplayContext, String holidayreplayTime) {
		this.holidayId = holidayId;
		this.userId = userId;
		this.userName = userName;
		this.holidayreplayContext = holidayreplayContext;
		this.holidayreplayTime = holidayreplayTime;
	}

	// Property accessors

	public Integer getHolidayreplayId() {
		return this.holidayreplayId;
	}

	public void setHolidayreplayId(Integer holidayreplayId) {
		this.holidayreplayId = holidayreplayId;
	}

	public Integer getHolidayId() {
		return this.holidayId;
	}

	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
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

	public String getHolidayreplayContext() {
		return this.holidayreplayContext;
	}

	public void setHolidayreplayContext(String holidayreplayContext) {
		this.holidayreplayContext = holidayreplayContext;
	}

	public String getHolidayreplayTime() {
		return this.holidayreplayTime;
	}

	public void setHolidayreplayTime(String holidayreplayTime) {
		this.holidayreplayTime = holidayreplayTime;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	

}