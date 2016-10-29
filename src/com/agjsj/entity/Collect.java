package com.agjsj.entity;

/**
 * Collect entity. @author MyEclipse Persistence Tools
 */

public class Collect implements java.io.Serializable {

	// Fields

	private Integer collectId;
	private Integer userId;
	private Integer jobId;
	private Integer holidayId;
	private Integer trainId;
	// Constructors

	/** default constructor */
	public Collect() {
	}

	/** minimal constructor */
	public Collect(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Collect(Integer userId, Integer jobId, Integer holidayId,
			Integer trainId) {
		this.userId = userId;
		this.jobId = jobId;
		this.holidayId = holidayId;
		this.trainId = trainId;
	}

	// Property accessors

	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "Collect [collectId=" + collectId + ", userId=" + userId
				+ ", jobId=" + jobId + ", holidayId=" + holidayId
				+ ", trainId=" + trainId + "]";
	}
	
	

	

}