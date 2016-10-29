package com.agjsj.entity;

/**
 * Talk entity. @author MyEclipse Persistence Tools
 */

public class Talk implements java.io.Serializable {

	// Fields

	private Integer talkId;
	private Integer userId;
	private String talkContext;
	private String talkTime;
	private Integer talkNumzan;
	private Integer talkNumza;
	private Integer talkNumreply;
	private Integer talkNumicon;
	private String talkIcon;
	private String user_name;
	private String user_icon;
	// Constructors

	/** default constructor */
	public Talk() {
	}

	/** full constructor */
	public Talk(Integer userId, String talkContext, String talkTime,
			Integer talkNumzan, Integer talkNumza, Integer talkNumreply,
			Integer talkNumicon, String talkIcon) {
		this.userId = userId;
		this.talkContext = talkContext;
		this.talkTime = talkTime;
		this.talkNumzan = talkNumzan;
		this.talkNumza = talkNumza;
		this.talkNumreply = talkNumreply;
		this.talkNumicon = talkNumicon;
		this.talkIcon = talkIcon;
	}

	// Property accessors

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

	public String getTalkContext() {
		return this.talkContext;
	}

	public void setTalkContext(String talkContext) {
		this.talkContext = talkContext;
	}

	public String getTalkTime() {
		return this.talkTime;
	}

	public void setTalkTime(String talkTime) {
		this.talkTime = talkTime;
	}

	public Integer getTalkNumzan() {
		return this.talkNumzan;
	}

	public void setTalkNumzan(Integer talkNumzan) {
		this.talkNumzan = talkNumzan;
	}

	public Integer getTalkNumza() {
		return this.talkNumza;
	}

	public void setTalkNumza(Integer talkNumza) {
		this.talkNumza = talkNumza;
	}

	public Integer getTalkNumreply() {
		return this.talkNumreply;
	}

	public void setTalkNumreply(Integer talkNumreply) {
		this.talkNumreply = talkNumreply;
	}

	public Integer getTalkNumicon() {
		return this.talkNumicon;
	}

	public void setTalkNumicon(Integer talkNumicon) {
		this.talkNumicon = talkNumicon;
	}

	public String getTalkIcon() {
		return this.talkIcon;
	}

	public void setTalkIcon(String talkIcon) {
		this.talkIcon = talkIcon;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_icon() {
		return user_icon;
	}

	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}
	

}