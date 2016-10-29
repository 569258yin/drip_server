package com.agjsj.entity;

/**
 * Optuanreplay entity. @author MyEclipse Persistence Tools
 */

public class Optuanreplay implements java.io.Serializable {

	// Fields

	private Integer optuanreplayId;
	private Integer opentuanId;
	private Integer userId;
	private String userName;
	private String userIcon;
	private String optuanreplayContext;
	private String optuanreplayTime;

	// Constructors

	/** default constructor */
	public Optuanreplay() {
	}

	/** full constructor */
	public Optuanreplay(Integer opentuanId, Integer userId, String userName,
			String optuanreplayContext, String optuanreplayTime) {
		this.opentuanId = opentuanId;
		this.userId = userId;
		this.userName = userName;
		this.optuanreplayContext = optuanreplayContext;
		this.optuanreplayTime = optuanreplayTime;
	}

	// Property accessors

	public Integer getOptuanreplayId() {
		return this.optuanreplayId;
	}

	public void setOptuanreplayId(Integer optuanreplayId) {
		this.optuanreplayId = optuanreplayId;
	}

	public Integer getOpentuanId() {
		return this.opentuanId;
	}

	public void setOpentuanId(Integer opentuanId) {
		this.opentuanId = opentuanId;
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

	public String getOptuanreplayContext() {
		return this.optuanreplayContext;
	}

	public void setOptuanreplayContext(String optuanreplayContext) {
		this.optuanreplayContext = optuanreplayContext;
	}

	public String getOptuanreplayTime() {
		return this.optuanreplayTime;
	}

	public void setOptuanreplayTime(String optuanreplayTime) {
		this.optuanreplayTime = optuanreplayTime;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

}