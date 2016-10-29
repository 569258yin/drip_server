package com.agjsj.entity;

/**
 * Train entity. @author MyEclipse Persistence Tools
 */

public class Train implements java.io.Serializable {

	// Fields

	private Integer trainId;
	private Integer userId;
	private String courseName;
	private Integer trainState;
	private String trainPrice;
	private String trainStartdate;
	private String trainEnddate;
	private String trainCity;
	private String trainAddress;
	private String trainTime;
	private String trainType;
	private String trainIcon;
	private String trainNotice;
	private String trainDescription;
	private String trainLinkman;
	private String trainPhone;

	// Constructors

	/** default constructor */
	public Train() {
	}

	/** minimal constructor */
	public Train(Integer userId, String courseName, String trainPrice,
			String trainStartdate, String trainEnddate, String trainCity,
			String trainAddress, String trainTime, String trainType,
			String trainIcon, String trainDescription, String trainLinkman,
			String trainPhone) {
		this.userId = userId;
		this.courseName = courseName;
		this.trainPrice = trainPrice;
		this.trainStartdate = trainStartdate;
		this.trainEnddate = trainEnddate;
		this.trainCity = trainCity;
		this.trainAddress = trainAddress;
		this.trainTime = trainTime;
		this.trainType = trainType;
		this.trainIcon = trainIcon;
		this.trainDescription = trainDescription;
		this.trainLinkman = trainLinkman;
		this.trainPhone = trainPhone;
	}

	/** full constructor */
	public Train(Integer userId, String courseName, String trainPrice,
			String trainStartdate, String trainEnddate, String trainCity,
			String trainAddress, String trainTime, String trainType,
			String trainIcon, String trainNotice, String trainDescription,
			String trainLinkman, String trainPhone) {
		this.userId = userId;
		this.courseName = courseName;
		this.trainPrice = trainPrice;
		this.trainStartdate = trainStartdate;
		this.trainEnddate = trainEnddate;
		this.trainCity = trainCity;
		this.trainAddress = trainAddress;
		this.trainTime = trainTime;
		this.trainType = trainType;
		this.trainIcon = trainIcon;
		this.trainNotice = trainNotice;
		this.trainDescription = trainDescription;
		this.trainLinkman = trainLinkman;
		this.trainPhone = trainPhone;
	}

	// Property accessors

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

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainPrice() {
		return this.trainPrice;
	}

	public void setTrainPrice(String trainPrice) {
		this.trainPrice = trainPrice;
	}

	public String getTrainStartdate() {
		return this.trainStartdate;
	}

	public void setTrainStartdate(String trainStartdate) {
		this.trainStartdate = trainStartdate;
	}

	public String getTrainEnddate() {
		return this.trainEnddate;
	}

	public void setTrainEnddate(String trainEnddate) {
		this.trainEnddate = trainEnddate;
	}

	public String getTrainCity() {
		return this.trainCity;
	}

	public void setTrainCity(String trainCity) {
		this.trainCity = trainCity;
	}

	public String getTrainAddress() {
		return this.trainAddress;
	}

	public void setTrainAddress(String trainAddress) {
		this.trainAddress = trainAddress;
	}

	public String getTrainTime() {
		return this.trainTime;
	}

	public void setTrainTime(String trainTime) {
		this.trainTime = trainTime;
	}

	public String getTrainType() {
		return this.trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public String getTrainIcon() {
		return this.trainIcon;
	}

	public void setTrainIcon(String trainIcon) {
		this.trainIcon = trainIcon;
	}

	public String getTrainNotice() {
		return this.trainNotice;
	}

	public void setTrainNotice(String trainNotice) {
		this.trainNotice = trainNotice;
	}

	public String getTrainDescription() {
		return this.trainDescription;
	}

	public void setTrainDescription(String trainDescription) {
		this.trainDescription = trainDescription;
	}

	public String getTrainLinkman() {
		return this.trainLinkman;
	}

	public void setTrainLinkman(String trainLinkman) {
		this.trainLinkman = trainLinkman;
	}

	public String getTrainPhone() {
		return this.trainPhone;
	}

	public void setTrainPhone(String trainPhone) {
		this.trainPhone = trainPhone;
	}
	

	public Integer getTrainState() {
		return trainState;
	}

	public void setTrainState(Integer trainState) {
		this.trainState = trainState;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", userId=" + userId
				+ ", courseName=" + courseName + ", trainPrice=" + trainPrice
				+ ", trainStartdate=" + trainStartdate + ", trainEnddate="
				+ trainEnddate + ", trainCity=" + trainCity + ", trainAddress="
				+ trainAddress + ", trainTime=" + trainTime + ", trainType="
				+ trainType + ", trainIcon=" + trainIcon + ", trainNotice="
				+ trainNotice + ", trainDescription=" + trainDescription
				+ ", trainLinkman=" + trainLinkman + ", trainPhone="
				+ trainPhone + "]";
	}
	
	
	

}