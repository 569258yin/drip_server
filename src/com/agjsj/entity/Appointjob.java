package com.agjsj.entity;

/**
 * Appointjob entity. @author MyEclipse Persistence Tools
 */

public class Appointjob implements java.io.Serializable {

	// Fields

	private Integer appointjobId;
	private Integer jobId;
	private Integer userId;
	private String appointjobName;
	private String appointjobPhone;
	private String appointjobNumcard;
	private String appointjobNumpeople;
	private String appointjobNotes;

	// Constructors

	/** default constructor */
	public Appointjob() {
	}

	/** full constructor */
	public Appointjob(Integer jobId, Integer userId, String appointjobName,
			String appointjobPhone, String appointjobNumcard,
			String appointjobNumpeople, String appointjobNotes) {
		this.jobId = jobId;
		this.userId = userId;
		this.appointjobName = appointjobName;
		this.appointjobPhone = appointjobPhone;
		this.appointjobNumcard = appointjobNumcard;
		this.appointjobNumpeople = appointjobNumpeople;
		this.appointjobNotes = appointjobNotes;
	}

	// Property accessors

	public Integer getAppointjobId() {
		return this.appointjobId;
	}

	public void setAppointjobId(Integer appointjobId) {
		this.appointjobId = appointjobId;
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

	public String getAppointjobName() {
		return this.appointjobName;
	}

	public void setAppointjobName(String appointjobName) {
		this.appointjobName = appointjobName;
	}

	public String getAppointjobPhone() {
		return this.appointjobPhone;
	}

	public void setAppointjobPhone(String appointjobPhone) {
		this.appointjobPhone = appointjobPhone;
	}

	public String getAppointjobNumcard() {
		return this.appointjobNumcard;
	}

	public void setAppointjobNumcard(String appointjobNumcard) {
		this.appointjobNumcard = appointjobNumcard;
	}

	public String getAppointjobNumpeople() {
		return this.appointjobNumpeople;
	}

	public void setAppointjobNumpeople(String appointjobNumpeople) {
		this.appointjobNumpeople = appointjobNumpeople;
	}

	public String getAppointjobNotes() {
		return this.appointjobNotes;
	}

	public void setAppointjobNotes(String appointjobNotes) {
		this.appointjobNotes = appointjobNotes;
	}

	@Override
	public String toString() {
		return "Appointjob [appointjobId=" + appointjobId + ", jobId=" + jobId
				+ ", userId=" + userId + ", appointjobName=" + appointjobName
				+ ", appointjobPhone=" + appointjobPhone
				+ ", appointjobNumcard=" + appointjobNumcard
				+ ", appointjobNumpeople=" + appointjobNumpeople
				+ ", appointjobNotes=" + appointjobNotes + "]";
	}
	
	

}