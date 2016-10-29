package com.agjsj.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Holiday entity. @author MyEclipse Persistence Tools
 */

public class Holiday implements java.io.Serializable {

	// Fields

	private Integer holidayId;
	private Integer userId;
	private Integer holidayState;
	private String holidayName;
	private String holidayPrice;
	private String holidayStartdate;
	private String holidayEnddate;
	private String holidayStartaddress;
	private String holidayEndaddress;
	private String holidayType;
	private Integer holidayStartvehicle;
	private Integer holidayEndvehicle;
	private Integer holidayHotel;
	private String holidayIntro;
	private String holidayNotice;
	private String holidayLookout;
	private String holidayIcon;
	private String holidayLinkman;
	private String holidayPhone;
//	private Set bks = new HashSet();
	// Constructors

	/** default constructor */
	public Holiday() {
	}

	/** minimal constructor */
	public Holiday(Integer userId, Integer holidayState, String holidayName,
			String holidayPrice, String holidayStartdate,
			String holidayEnddate, String holidayStartaddress,
			String holidayEndaddress, String holidayType,
			Integer holidayStartvehicle, Integer holidayEndvehicle,
			Integer holidayHotel, String holidayIntro, String holidayIcon,
			String holidayLinkman, String holidayPhone) {
		this.userId = userId;
		this.holidayState = holidayState;
		this.holidayName = holidayName;
		this.holidayPrice = holidayPrice;
		this.holidayStartdate = holidayStartdate;
		this.holidayEnddate = holidayEnddate;
		this.holidayStartaddress = holidayStartaddress;
		this.holidayEndaddress = holidayEndaddress;
		this.holidayType = holidayType;
		this.holidayStartvehicle = holidayStartvehicle;
		this.holidayEndvehicle = holidayEndvehicle;
		this.holidayHotel = holidayHotel;
		this.holidayIntro = holidayIntro;
		this.holidayIcon = holidayIcon;
		this.holidayLinkman = holidayLinkman;
		this.holidayPhone = holidayPhone;
	}

	/** full constructor */
	public Holiday(Integer userId, Integer holidayState, String holidayName,
			String holidayPrice, String holidayStartdate,
			String holidayEnddate, String holidayStartaddress,
			String holidayEndaddress, String holidayType,
			Integer holidayStartvehicle, Integer holidayEndvehicle,
			Integer holidayHotel, String holidayIntro, String holidayNotice,
			String holidayLookout, String holidayIcon, String holidayLinkman,
			String holidayPhone) {
		this.userId = userId;
		this.holidayState = holidayState;
		this.holidayName = holidayName;
		this.holidayPrice = holidayPrice;
		this.holidayStartdate = holidayStartdate;
		this.holidayEnddate = holidayEnddate;
		this.holidayStartaddress = holidayStartaddress;
		this.holidayEndaddress = holidayEndaddress;
		this.holidayType = holidayType;
		this.holidayStartvehicle = holidayStartvehicle;
		this.holidayEndvehicle = holidayEndvehicle;
		this.holidayHotel = holidayHotel;
		this.holidayIntro = holidayIntro;
		this.holidayNotice = holidayNotice;
		this.holidayLookout = holidayLookout;
		this.holidayIcon = holidayIcon;
		this.holidayLinkman = holidayLinkman;
		this.holidayPhone = holidayPhone;
	}

	// Property accessors

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

	public Integer getHolidayState() {
		return this.holidayState;
	}

	public void setHolidayState(Integer holidayState) {
		this.holidayState = holidayState;
	}

	public String getHolidayName() {
		return this.holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getHolidayPrice() {
		return this.holidayPrice;
	}

	public void setHolidayPrice(String holidayPrice) {
		this.holidayPrice = holidayPrice;
	}

	public String getHolidayStartdate() {
		return this.holidayStartdate;
	}

	public void setHolidayStartdate(String holidayStartdate) {
		this.holidayStartdate = holidayStartdate;
	}

	public String getHolidayEnddate() {
		return this.holidayEnddate;
	}

	public void setHolidayEnddate(String holidayEnddate) {
		this.holidayEnddate = holidayEnddate;
	}

	public String getHolidayStartaddress() {
		return this.holidayStartaddress;
	}

	public void setHolidayStartaddress(String holidayStartaddress) {
		this.holidayStartaddress = holidayStartaddress;
	}

	public String getHolidayEndaddress() {
		return this.holidayEndaddress;
	}

	public void setHolidayEndaddress(String holidayEndaddress) {
		this.holidayEndaddress = holidayEndaddress;
	}

	public String getHolidayType() {
		return this.holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public Integer getHolidayStartvehicle() {
		return this.holidayStartvehicle;
	}

	public void setHolidayStartvehicle(Integer holidayStartvehicle) {
		this.holidayStartvehicle = holidayStartvehicle;
	}

	public Integer getHolidayEndvehicle() {
		return this.holidayEndvehicle;
	}

	public void setHolidayEndvehicle(Integer holidayEndvehicle) {
		this.holidayEndvehicle = holidayEndvehicle;
	}

	public Integer getHolidayHotel() {
		return this.holidayHotel;
	}

	public void setHolidayHotel(Integer holidayHotel) {
		this.holidayHotel = holidayHotel;
	}

	public String getHolidayIntro() {
		return this.holidayIntro;
	}

	public void setHolidayIntro(String holidayIntro) {
		this.holidayIntro = holidayIntro;
	}

	public String getHolidayNotice() {
		return this.holidayNotice;
	}

	public void setHolidayNotice(String holidayNotice) {
		this.holidayNotice = holidayNotice;
	}

	public String getHolidayLookout() {
		return this.holidayLookout;
	}

	public void setHolidayLookout(String holidayLookout) {
		this.holidayLookout = holidayLookout;
	}

	public String getHolidayIcon() {
		return this.holidayIcon;
	}

	public void setHolidayIcon(String holidayIcon) {
		this.holidayIcon = holidayIcon;
	}

	public String getHolidayLinkman() {
		return this.holidayLinkman;
	}

	public void setHolidayLinkman(String holidayLinkman) {
		this.holidayLinkman = holidayLinkman;
	}

	public String getHolidayPhone() {
		return this.holidayPhone;
	}

	public void setHolidayPhone(String holidayPhone) {
		this.holidayPhone = holidayPhone;
	}
//
//	public Set getBks() {
//		return bks;
//	}
//
//	public void setBks(Set bks) {
//		this.bks = bks;
//	}
	
	

}