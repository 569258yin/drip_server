package com.agjsj.entity;

/**
 * Reccom entity. @author MyEclipse Persistence Tools
 */

public class Reccom implements java.io.Serializable {

	// Fields

	private Integer reccomId;
	private Integer tag;
	private Integer jobId;
	private Integer holidayId;
	private Integer trainId;

	// Constructors

	/** default constructor */
	public Reccom() {
	}

	/** minimal constructor */
	public Reccom(Integer tag) {
		this.tag = tag;
	}

	/** full constructor */
	public Reccom(Integer tag, Integer jobId, Integer holidayId, Integer trainId) {
		this.tag = tag;
		this.jobId = jobId;
		this.holidayId = holidayId;
		this.trainId = trainId;
	}

	// Property accessors

	public Integer getReccomId() {
		return this.reccomId;
	}

	public void setReccomId(Integer reccomId) {
		this.reccomId = reccomId;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getHolidayId() {
		return this.holidayId;
	}

	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

}