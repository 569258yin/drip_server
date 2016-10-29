package com.agjsj.entity;

/**
 * Job entity. @author MyEclipse Persistence Tools
 */

public class Job implements java.io.Serializable {

	// Fields

	private Integer jobId;
	private Integer userId;
	private String jobName;
	private Integer jobType;
	private String jobRequire;
	private String jobDescription;
	private String jobNotice;
	private String jobMoney;
	private Integer jobPeriod;
	private Integer jobNumber;
	private String jobAddress;
	private String jobAddressinfo;
	private String jobStartdate;
	private String jobEnddate;
	private String jobTimes;
	private String jobLinkman;
	private String jobPhone;
	private Integer jobState;
	private String jobIcon;

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** full constructor */
	public Job(Integer userId, String jobName, Integer jobType,
			String jobRequire, String jobDescription, String jobNotice,
			String jobMoney, Integer jobPeriod, Integer jobNumber,
			String jobAddress, String jobAddressinfo, String jobStartdate,
			String jobEnddate, String jobTimes, String jobLinkman,
			String jobPhone, Integer jobState) {
		this.userId = userId;
		this.jobName = jobName;
		this.jobType = jobType;
		this.jobRequire = jobRequire;
		this.jobDescription = jobDescription;
		this.jobNotice = jobNotice;
		this.jobMoney = jobMoney;
		this.jobPeriod = jobPeriod;
		this.jobNumber = jobNumber;
		this.jobAddress = jobAddress;
		this.jobAddressinfo = jobAddressinfo;
		this.jobStartdate = jobStartdate;
		this.jobEnddate = jobEnddate;
		this.jobTimes = jobTimes;
		this.jobLinkman = jobLinkman;
		this.jobPhone = jobPhone;
		this.jobState = jobState;
	}

	// Property accessors

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

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobType() {
		return this.jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getJobRequire() {
		return this.jobRequire;
	}

	public void setJobRequire(String jobRequire) {
		this.jobRequire = jobRequire;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobNotice() {
		return this.jobNotice;
	}

	public void setJobNotice(String jobNotice) {
		this.jobNotice = jobNotice;
	}

	public String getJobMoney() {
		return this.jobMoney;
	}

	public void setJobMoney(String jobMoney) {
		this.jobMoney = jobMoney;
	}

	public Integer getJobPeriod() {
		return this.jobPeriod;
	}

	public void setJobPeriod(Integer jobPeriod) {
		this.jobPeriod = jobPeriod;
	}

	public Integer getJobNumber() {
		return this.jobNumber;
	}

	public void setJobNumber(Integer jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getJobAddress() {
		return this.jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}

	public String getJobAddressinfo() {
		return this.jobAddressinfo;
	}

	public void setJobAddressinfo(String jobAddressinfo) {
		this.jobAddressinfo = jobAddressinfo;
	}

	public String getJobStartdate() {
		return this.jobStartdate;
	}

	public void setJobStartdate(String jobStartdate) {
		this.jobStartdate = jobStartdate;
	}

	public String getJobEnddate() {
		return this.jobEnddate;
	}

	public void setJobEnddate(String jobEnddate) {
		this.jobEnddate = jobEnddate;
	}

	public String getJobTimes() {
		return this.jobTimes;
	}

	public void setJobTimes(String jobTimes) {
		this.jobTimes = jobTimes;
	}

	public String getJobLinkman() {
		return this.jobLinkman;
	}

	public void setJobLinkman(String jobLinkman) {
		this.jobLinkman = jobLinkman;
	}

	public String getJobPhone() {
		return this.jobPhone;
	}

	public void setJobPhone(String jobPhone) {
		this.jobPhone = jobPhone;
	}

	public Integer getJobState() {
		return this.jobState;
	}

	public void setJobState(Integer jobState) {
		this.jobState = jobState;
	}

	public String getJobIcon() {
		return jobIcon;
	}

	public void setJobIcon(String jobIcon) {
		this.jobIcon = jobIcon;
	}
	

}