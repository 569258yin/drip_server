package com.agjsj.entity;

/**
 * Appointholiday entity. @author MyEclipse Persistence Tools
 */

public class Appointholiday implements java.io.Serializable {

	// Fields

	private Integer appointholidayId;
	private Integer holidayId;
	private Integer userId;
	private String appointholidayName;
	private String appointholidayPhone;
	private String appointholidayNumcard;
	private Integer appointholidayNumpeople;
	private String appointholidayNotes;

	// Constructors

	/** default constructor */
	public Appointholiday() {
	}

	/** minimal constructor */
	public Appointholiday(Integer holidayId, Integer userId,
			String appointholidayName, String appointholidayPhone,
			String appointholidayNumcard, Integer appointholidayNumpeople) {
		this.holidayId = holidayId;
		this.userId = userId;
		this.appointholidayName = appointholidayName;
		this.appointholidayPhone = appointholidayPhone;
		this.appointholidayNumcard = appointholidayNumcard;
		this.appointholidayNumpeople = appointholidayNumpeople;
	}

	/** full constructor */
	public Appointholiday(Integer holidayId, Integer userId,
			String appointholidayName, String appointholidayPhone,
			String appointholidayNumcard, Integer appointholidayNumpeople,
			String appointholidayNotes) {
		this.holidayId = holidayId;
		this.userId = userId;
		this.appointholidayName = appointholidayName;
		this.appointholidayPhone = appointholidayPhone;
		this.appointholidayNumcard = appointholidayNumcard;
		this.appointholidayNumpeople = appointholidayNumpeople;
		this.appointholidayNotes = appointholidayNotes;
	}

	// Property accessors

	public Integer getAppointholidayId() {
		return this.appointholidayId;
	}

	public void setAppointholidayId(Integer appointholidayId) {
		this.appointholidayId = appointholidayId;
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

	public String getAppointholidayName() {
		return this.appointholidayName;
	}

	public void setAppointholidayName(String appointholidayName) {
		this.appointholidayName = appointholidayName;
	}

	public String getAppointholidayPhone() {
		return this.appointholidayPhone;
	}

	public void setAppointholidayPhone(String appointholidayPhone) {
		this.appointholidayPhone = appointholidayPhone;
	}

	public String getAppointholidayNumcard() {
		return this.appointholidayNumcard;
	}

	public void setAppointholidayNumcard(String appointholidayNumcard) {
		this.appointholidayNumcard = appointholidayNumcard;
	}

	public Integer getAppointholidayNumpeople() {
		return this.appointholidayNumpeople;
	}

	public void setAppointholidayNumpeople(Integer appointholidayNumpeople) {
		this.appointholidayNumpeople = appointholidayNumpeople;
	}

	public String getAppointholidayNotes() {
		return this.appointholidayNotes;
	}

	public void setAppointholidayNotes(String appointholidayNotes) {
		this.appointholidayNotes = appointholidayNotes;
	}

}