package com.agjsj.entity;

/**
 * Talkreplay entity. @author MyEclipse Persistence Tools
 */

public class Talkreplay implements java.io.Serializable {

	// Fields

	private Integer talkreplayId;
	private Integer talkId;
	private Integer userId;
	private String talkreplayContext;
	private String talkreplayTime;

	// Constructors

	/** default constructor */
	public Talkreplay() {
	}

	/** full constructor */
	public Talkreplay(Integer talkId, Integer userId, String talkreplayContext,
			String talkreplayTime) {
		this.talkId = talkId;
		this.userId = userId;
		this.talkreplayContext = talkreplayContext;
		this.talkreplayTime = talkreplayTime;
	}

	// Property accessors

	public Integer getTalkreplayId() {
		return this.talkreplayId;
	}

	public void setTalkreplayId(Integer talkreplayId) {
		this.talkreplayId = talkreplayId;
	}

	public Integer getTalkId() {
		return this.talkId;
	}

	public void setTalkId(Integer talkId) {
		this.talkId = talkId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTalkreplayContext() {
		return this.talkreplayContext;
	}

	public void setTalkreplayContext(String talkreplayContext) {
		this.talkreplayContext = talkreplayContext;
	}

	public String getTalkreplayTime() {
		return this.talkreplayTime;
	}

	public void setTalkreplayTime(String talkreplayTime) {
		this.talkreplayTime = talkreplayTime;
	}

}