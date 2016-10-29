package com.agjsj.entity;

/**
 * Appointtrain entity. @author MyEclipse Persistence Tools
 */

public class Appointtrain implements java.io.Serializable {

	// Fields

	private Integer appointtrainId;
	private Integer trainId;
	private Integer userId;
	private String appointtrainName;
	private String appointtrainPhone;
	private String appointtrainNumcard;
	private Integer appointtrainNumpeople;
	private String appointtrainNotes;

	// Constructors

	/** default constructor */
	public Appointtrain() {
	}

	/** minimal constructor */
	public Appointtrain(Integer trainId, Integer userId,
			String appointtrainName, String appointtrainPhone,
			String appointtrainNumcard, Integer appointtrainNumpeople) {
		this.trainId = trainId;
		this.userId = userId;
		this.appointtrainName = appointtrainName;
		this.appointtrainPhone = appointtrainPhone;
		this.appointtrainNumcard = appointtrainNumcard;
		this.appointtrainNumpeople = appointtrainNumpeople;
	}

	/** full constructor */
	public Appointtrain(Integer trainId, Integer userId,
			String appointtrainName, String appointtrainPhone,
			String appointtrainNumcard, Integer appointtrainNumpeople,
			String appointtrainNotes) {
		this.trainId = trainId;
		this.userId = userId;
		this.appointtrainName = appointtrainName;
		this.appointtrainPhone = appointtrainPhone;
		this.appointtrainNumcard = appointtrainNumcard;
		this.appointtrainNumpeople = appointtrainNumpeople;
		this.appointtrainNotes = appointtrainNotes;
	}

	// Property accessors

	public Integer getAppointtrainId() {
		return this.appointtrainId;
	}

	public void setAppointtrainId(Integer appointtrainId) {
		this.appointtrainId = appointtrainId;
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

	public String getAppointtrainName() {
		return this.appointtrainName;
	}

	public void setAppointtrainName(String appointtrainName) {
		this.appointtrainName = appointtrainName;
	}

	public String getAppointtrainPhone() {
		return this.appointtrainPhone;
	}

	public void setAppointtrainPhone(String appointtrainPhone) {
		this.appointtrainPhone = appointtrainPhone;
	}

	public String getAppointtrainNumcard() {
		return this.appointtrainNumcard;
	}

	public void setAppointtrainNumcard(String appointtrainNumcard) {
		this.appointtrainNumcard = appointtrainNumcard;
	}

	public Integer getAppointtrainNumpeople() {
		return this.appointtrainNumpeople;
	}

	public void setAppointtrainNumpeople(Integer appointtrainNumpeople) {
		this.appointtrainNumpeople = appointtrainNumpeople;
	}

	public String getAppointtrainNotes() {
		return this.appointtrainNotes;
	}

	public void setAppointtrainNotes(String appointtrainNotes) {
		this.appointtrainNotes = appointtrainNotes;
	}

	@Override
	public String toString() {
		return "Appointtrain [appointtrainId=" + appointtrainId + ", trainId="
				+ trainId + ", userId=" + userId + ", appointtrainName="
				+ appointtrainName + ", appointtrainPhone=" + appointtrainPhone
				+ ", appointtrainNumcard=" + appointtrainNumcard
				+ ", appointtrainNumpeople=" + appointtrainNumpeople
				+ ", appointtrainNotes=" + appointtrainNotes + "]";
	}

}