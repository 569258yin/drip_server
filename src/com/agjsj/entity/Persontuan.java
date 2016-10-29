package com.agjsj.entity;

/**
 * Persontuan entity. @author MyEclipse Persistence Tools
 */

public class Persontuan implements java.io.Serializable {

	// Fields

	private Integer persontuanId;
	private Integer userId;
	private String persontuanRealname;
	private String persontuanTitle;
	private String persontuanQq;
	private String persontuanStartplace;
	private String persontuanEndplace;
	private String persontuanStartdate;
	private String persontuanDays;
	private String persontuanPeople;
	private String persontuanMoney;
	private String persontuanTraveltype;
	private String persontuanHotelreq;
	private String persontuanHotelplace;
	private String persontuanHoteltype;
	private String persontuanLinktime;
	private String persontuanIsguide;
	private String persontuanOtherreq;
	private String persontuanPhone;
	private String PersontuanUsericon;
	private String PersontuanTime;

	// Constructors

	/** default constructor */
	public Persontuan() {
	}

	/** minimal constructor */
	public Persontuan(Integer userId, String persontuanRealname,
			String persontuanTitle, String persontuanQq,
			String persontuanStartplace, String persontuanEndplace,
			String persontuanStartdate, String persontuanDays,
			String persontuanPeople, String persontuanMoney,
			String persontuanTraveltype, String persontuanHotelreq,
			String persontuanHotelplace, String persontuanHoteltype,
			String persontuanLinktime, String persontuanIsguide,
			String persontuanPhone) {
		this.userId = userId;
		this.persontuanRealname = persontuanRealname;
		this.persontuanTitle = persontuanTitle;
		this.persontuanQq = persontuanQq;
		this.persontuanStartplace = persontuanStartplace;
		this.persontuanEndplace = persontuanEndplace;
		this.persontuanStartdate = persontuanStartdate;
		this.persontuanDays = persontuanDays;
		this.persontuanPeople = persontuanPeople;
		this.persontuanMoney = persontuanMoney;
		this.persontuanTraveltype = persontuanTraveltype;
		this.persontuanHotelreq = persontuanHotelreq;
		this.persontuanHotelplace = persontuanHotelplace;
		this.persontuanHoteltype = persontuanHoteltype;
		this.persontuanLinktime = persontuanLinktime;
		this.persontuanIsguide = persontuanIsguide;
		this.persontuanPhone = persontuanPhone;
	}

	/** full constructor */
	public Persontuan(Integer userId, String persontuanRealname,
			String persontuanTitle, String persontuanQq,
			String persontuanStartplace, String persontuanEndplace,
			String persontuanStartdate, String persontuanDays,
			String persontuanPeople, String persontuanMoney,
			String persontuanTraveltype, String persontuanHotelreq,
			String persontuanHotelplace, String persontuanHoteltype,
			String persontuanLinktime, String persontuanIsguide,
			String persontuanOtherreq, String persontuanPhone) {
		this.userId = userId;
		this.persontuanRealname = persontuanRealname;
		this.persontuanTitle = persontuanTitle;
		this.persontuanQq = persontuanQq;
		this.persontuanStartplace = persontuanStartplace;
		this.persontuanEndplace = persontuanEndplace;
		this.persontuanStartdate = persontuanStartdate;
		this.persontuanDays = persontuanDays;
		this.persontuanPeople = persontuanPeople;
		this.persontuanMoney = persontuanMoney;
		this.persontuanTraveltype = persontuanTraveltype;
		this.persontuanHotelreq = persontuanHotelreq;
		this.persontuanHotelplace = persontuanHotelplace;
		this.persontuanHoteltype = persontuanHoteltype;
		this.persontuanLinktime = persontuanLinktime;
		this.persontuanIsguide = persontuanIsguide;
		this.persontuanOtherreq = persontuanOtherreq;
		this.persontuanPhone = persontuanPhone;
	}

	// Property accessors

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

	public String getPersontuanRealname() {
		return this.persontuanRealname;
	}

	public void setPersontuanRealname(String persontuanRealname) {
		this.persontuanRealname = persontuanRealname;
	}

	public String getPersontuanTitle() {
		return this.persontuanTitle;
	}

	public void setPersontuanTitle(String persontuanTitle) {
		this.persontuanTitle = persontuanTitle;
	}

	public String getPersontuanQq() {
		return this.persontuanQq;
	}

	public void setPersontuanQq(String persontuanQq) {
		this.persontuanQq = persontuanQq;
	}

	public String getPersontuanStartplace() {
		return this.persontuanStartplace;
	}

	public void setPersontuanStartplace(String persontuanStartplace) {
		this.persontuanStartplace = persontuanStartplace;
	}

	public String getPersontuanEndplace() {
		return this.persontuanEndplace;
	}

	public void setPersontuanEndplace(String persontuanEndplace) {
		this.persontuanEndplace = persontuanEndplace;
	}

	public String getPersontuanStartdate() {
		return this.persontuanStartdate;
	}

	public void setPersontuanStartdate(String persontuanStartdate) {
		this.persontuanStartdate = persontuanStartdate;
	}

	public String getPersontuanDays() {
		return this.persontuanDays;
	}

	public void setPersontuanDays(String persontuanDays) {
		this.persontuanDays = persontuanDays;
	}

	public String getPersontuanPeople() {
		return this.persontuanPeople;
	}

	public void setPersontuanPeople(String persontuanPeople) {
		this.persontuanPeople = persontuanPeople;
	}

	public String getPersontuanMoney() {
		return this.persontuanMoney;
	}

	public void setPersontuanMoney(String persontuanMoney) {
		this.persontuanMoney = persontuanMoney;
	}

	public String getPersontuanTraveltype() {
		return this.persontuanTraveltype;
	}

	public void setPersontuanTraveltype(String persontuanTraveltype) {
		this.persontuanTraveltype = persontuanTraveltype;
	}

	public String getPersontuanHotelreq() {
		return this.persontuanHotelreq;
	}

	public void setPersontuanHotelreq(String persontuanHotelreq) {
		this.persontuanHotelreq = persontuanHotelreq;
	}

	public String getPersontuanHotelplace() {
		return this.persontuanHotelplace;
	}

	public void setPersontuanHotelplace(String persontuanHotelplace) {
		this.persontuanHotelplace = persontuanHotelplace;
	}

	public String getPersontuanHoteltype() {
		return this.persontuanHoteltype;
	}

	public void setPersontuanHoteltype(String persontuanHoteltype) {
		this.persontuanHoteltype = persontuanHoteltype;
	}

	public String getPersontuanLinktime() {
		return this.persontuanLinktime;
	}

	public void setPersontuanLinktime(String persontuanLinktime) {
		this.persontuanLinktime = persontuanLinktime;
	}

	public String getPersontuanIsguide() {
		return this.persontuanIsguide;
	}

	public void setPersontuanIsguide(String persontuanIsguide) {
		this.persontuanIsguide = persontuanIsguide;
	}

	public String getPersontuanOtherreq() {
		return this.persontuanOtherreq;
	}

	public void setPersontuanOtherreq(String persontuanOtherreq) {
		this.persontuanOtherreq = persontuanOtherreq;
	}

	public String getPersontuanPhone() {
		return this.persontuanPhone;
	}

	public void setPersontuanPhone(String persontuanPhone) {
		this.persontuanPhone = persontuanPhone;
	}
	

	public String getPersontuanUsericon() {
		return PersontuanUsericon;
	}

	public void setPersontuanUsericon(String persontuanUsericon) {
		PersontuanUsericon = persontuanUsericon;
	}

	public String getPersontuanTime() {
		return PersontuanTime;
	}

	public void setPersontuanTime(String persontuanTime) {
		PersontuanTime = persontuanTime;
	}

	@Override
	public String toString() {
		return "Persontuan [persontuanId=" + persontuanId + ", userId="
				+ userId + ", persontuanRealname=" + persontuanRealname
				+ ", persontuanTitle=" + persontuanTitle + ", persontuanQq="
				+ persontuanQq + ", persontuanStartplace="
				+ persontuanStartplace + ", persontuanEndplace="
				+ persontuanEndplace + ", persontuanStartdate="
				+ persontuanStartdate + ", persontuanDays=" + persontuanDays
				+ ", persontuanPeople=" + persontuanPeople
				+ ", persontuanMoney=" + persontuanMoney
				+ ", persontuanTraveltype=" + persontuanTraveltype
				+ ", persontuanHotelreq=" + persontuanHotelreq
				+ ", persontuanHotelplace=" + persontuanHotelplace
				+ ", persontuanHoteltype=" + persontuanHoteltype
				+ ", persontuanLinktime=" + persontuanLinktime
				+ ", persontuanIsguide=" + persontuanIsguide
				+ ", persontuanOtherreq=" + persontuanOtherreq
				+ ", persontuanPhone=" + persontuanPhone + "]";
	}
	
	

}