package com.agjsj.entity;
/*
 * 验证码
 */
public class Validata {
	private String number;
	private long time;
	private boolean isuse = false;
	
	
	
	public Validata(String number, long time) {
		super();
		this.number = number;
		this.time = time;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isIsuse() {
		return isuse;
	}
	public void setIsuse(boolean isuse) {
		this.isuse = isuse;
	}
	@Override
	public String toString() {
		return "Validata [number=" + number + ", time=" + time + ", isuse="
				+ isuse + "]";
	}
	
}
