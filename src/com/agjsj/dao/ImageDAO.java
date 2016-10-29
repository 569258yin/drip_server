package com.agjsj.dao;

public interface ImageDAO {
	/**
	 * 添加用户icon
	 * @param url
	 * @return
	 */
	public boolean addUserIcon(String url,Integer id);
	/**
	 * 添加工作图片
	 * @param url
	 * @param id
	 * @return
	 */
	public boolean addJobIcon(String url,Integer id);
	/**
	 * 添加旅行图片
	 * @param url
	 * @param id
	 * @return
	 */
	public boolean addHolidayIcon(String url,Integer id);
	/**
	 * 添加培训图片
	 * @param url
	 * @param id
	 * @return
	 */
	public boolean addTrainIcon(String url,Integer id);
	/**
	 * 添加神吐槽
	 * @param url
	 * @param id
	 * @return
	 */
	public boolean addTalkIcon(String url,Integer id);
	
}
