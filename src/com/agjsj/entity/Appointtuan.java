package com.agjsj.entity;

/**
 * Appointtuan entity. @author MyEclipse Persistence Tools
 */

public class Appointtuan implements java.io.Serializable {

	// Fields

	private Integer appointtuanId;
	private Integer persontuanId;
	private Integer userId;
	private String appointtuanName;
	private String appointtuanPhone;
	private String appointtuanNumcard;
	private Integer appointtuanNumpeople;
	private String appointtuanNotes;

	// Constructors

	/** default constructor */
	public Appointtuan() {
	}

	/** minimal constructor */
	public Appointtuan(Integer persontuanId, Integer userId,
			String appointtuanName, String appointtuanPhone,
			String appointtuanNumcard, Integer appointtuanNumpeople) {
		this.persontuanId = persontuanId;
		this.userId = userId;
		this.appointtuanName = appointtuanName;
		this.appointtuanPhone = appointtuanPhone;
		this.appointtuanNumcard = appointtuanNumcard;
		this.appointtuanNumpeople = appointtuanNumpeople;
	}

	/** full constructor */
	public Appointtuan(Integer persontuanId, Integer userId,
			String appointtuanName, String appointtuanPhone,
			String appointtuanNumcard, Integer appointtuanNumpeople,
			String appointtuanNotes) {
		this.persontuanId = persontuanId;
		this.userId = userId;
		this.appointtuanName = appointtuanName;
		this.appointtuanPhone = appointtuanPhone;
		this.appointtuanNumcard = appointtuanNumcard;
		this.appointtuanNumpeople = appointtuanNumpeople;
		this.appointtuanNotes = appointtuanNotes;
	}

	// Property accessors

	public Integer getAppointtuanId() {
		return this.appointtuanId;
	}

	public void setAppointtuanId(Integer appointtuanId) {
		this.appointtuanId = appointtuanId;
	}

	public Integer getPersontuanId() {
		return this.persontuanId;
	}

	public void setPersontuanId(Integer persontuanId) {
		this.persontuanId = persontuanId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAppointtuanName() {
		return this.appointtuanName;
	}

	public void setAppointtuanName(String appointtuanName) {
		this.appointtuanName = appointtuanName;
	}

	public String getAppointtuanPhone() {
		return this.appointtuanPhone;
	}

	public void setAppointtuanPhone(String appointtuanPhone) {
		this.appointtuanPhone = appointtuanPhone;
	}

	public String getAppointtuanNumcard() {
		return this.appointtuanNumcard;
	}

	public void setAppointtuanNumcard(String appointtuanNumcard) {
		this.appointtuanNumcard = appointtuanNumcard;
	}

	public Integer getAppointtuanNumpeople() {
		return this.appointtuanNumpeople;
	}

	public void setAppointtuanNumpeople(Integer appointtuanNumpeople) {
		this.appointtuanNumpeople = appointtuanNumpeople;
	}

	public String getAppointtuanNotes() {
		return this.appointtuanNotes;
	}

	public void setAppointtuanNotes(String appointtuanNotes) {
		this.appointtuanNotes = appointtuanNotes;
	}

}