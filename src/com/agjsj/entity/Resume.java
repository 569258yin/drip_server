package com.agjsj.entity;

/**
 * Resume entity. @author MyEclipse Persistence Tools
 */

public class Resume implements java.io.Serializable {

	// Fields

	private Integer resumeId;
	private Integer userId;
	private String resumeName;
	private Integer resumeSex;
	private Integer resumeAge;
	private String resumeNation;
	private String resumeStatus;
	private String resumePlace;
	private String resumeSchool;
	private String resumeMajor;
	private String resumeEducation;
	private String resumeIntention;
	private String resumePhone;
	private String resumeEmail;
	private String resumeAddress;
	private String resumeStrong;
	private String resumeHonor;
	private String resumeExperience;
	private String resumeMyevaluate;

	// Constructors

	/** default constructor */
	public Resume() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getResumeName() {
		return this.resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	public Integer getResumeAge() {
		return this.resumeAge;
	}

	public void setResumeAge(Integer resumeAge) {
		this.resumeAge = resumeAge;
	}

	public String getResumeNation() {
		return this.resumeNation;
	}

	public void setResumeNation(String resumeNation) {
		this.resumeNation = resumeNation;
	}

	public String getResumeStatus() {
		return this.resumeStatus;
	}

	public void setResumeStatus(String resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	public String getResumePlace() {
		return this.resumePlace;
	}

	public void setResumePlace(String resumePlace) {
		this.resumePlace = resumePlace;
	}

	public String getResumeSchool() {
		return this.resumeSchool;
	}

	public void setResumeSchool(String resumeSchool) {
		this.resumeSchool = resumeSchool;
	}

	public String getResumeMajor() {
		return this.resumeMajor;
	}

	public void setResumeMajor(String resumeMajor) {
		this.resumeMajor = resumeMajor;
	}

	public String getResumeEducation() {
		return this.resumeEducation;
	}

	public void setResumeEducation(String resumeEducation) {
		this.resumeEducation = resumeEducation;
	}

	public String getResumeIntention() {
		return this.resumeIntention;
	}

	public void setResumeIntention(String resumeIntention) {
		this.resumeIntention = resumeIntention;
	}

	public String getResumePhone() {
		return this.resumePhone;
	}

	public void setResumePhone(String resumePhone) {
		this.resumePhone = resumePhone;
	}

	public String getResumeEmail() {
		return this.resumeEmail;
	}

	public void setResumeEmail(String resumeEmail) {
		this.resumeEmail = resumeEmail;
	}

	public String getResumeAddress() {
		return this.resumeAddress;
	}

	public void setResumeAddress(String resumeAddress) {
		this.resumeAddress = resumeAddress;
	}

	public String getResumeStrong() {
		return this.resumeStrong;
	}

	public void setResumeStrong(String resumeStrong) {
		this.resumeStrong = resumeStrong;
	}

	public String getResumeHonor() {
		return this.resumeHonor;
	}

	public void setResumeHonor(String resumeHonor) {
		this.resumeHonor = resumeHonor;
	}

	public String getResumeExperience() {
		return this.resumeExperience;
	}

	public void setResumeExperience(String resumeExperience) {
		this.resumeExperience = resumeExperience;
	}

	public String getResumeMyevaluate() {
		return this.resumeMyevaluate;
	}

	public void setResumeMyevaluate(String resumeMyevaluate) {
		this.resumeMyevaluate = resumeMyevaluate;
	}
	

	public Integer getResumeSex() {
		return resumeSex;
	}

	public void setResumeSex(Integer resumeSex) {
		this.resumeSex = resumeSex;
	}

	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", userId=" + userId
				+ ", resumeName=" + resumeName + ", resumeAge=" + resumeAge
				+ ", resumeNation=" + resumeNation + ", resumeStatus="
				+ resumeStatus + ", resumePlace=" + resumePlace
				+ ", resumeSchool=" + resumeSchool + ", resumeMajor="
				+ resumeMajor + ", resumeEducation=" + resumeEducation
				+ ", resumeIntention=" + resumeIntention + ", resumePhone="
				+ resumePhone + ", resumeEmail=" + resumeEmail
				+ ", resumeAddress=" + resumeAddress + ", resumeStrong="
				+ resumeStrong + ", resumeHonor=" + resumeHonor
				+ ", resumeExperience=" + resumeExperience
				+ ", resumeMyevaluate=" + resumeMyevaluate + "]";
	}
	
	

}