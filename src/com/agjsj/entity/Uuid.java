package com.agjsj.entity;

/**
 * Uuid entity. @author MyEclipse Persistence Tools
 */

public class Uuid implements java.io.Serializable {

	// Fields

	private Integer uuid;
	private String loginname;
	private String newvalus;

	// Constructors

	/** default constructor */
	public Uuid() {
	}

	/** full constructor */
	public Uuid(String loginname, String newvalus) {
		this.loginname = loginname;
		this.newvalus = newvalus;
	}

	// Property accessors

	public Integer getUuid() {
		return this.uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getNewvalus() {
		return this.newvalus;
	}

	public void setNewvalus(String newvalus) {
		this.newvalus = newvalus;
	}

}