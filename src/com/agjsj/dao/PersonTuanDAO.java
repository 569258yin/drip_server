package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Job;
import com.agjsj.entity.Persontuan;

public interface PersonTuanDAO {
	/**
	 * 发布个人开团
	 * @param persontuan
	 * @param user_id
	 * @return
	 */
	public boolean sendPersonTuan(Persontuan persontuan,Integer user_id);
	
	/**
	 * 获取个人发布旅行团的所有信息
	 * @param user_id
	 * @return
	 */
	public List<Persontuan> getPersonAllTuan(Integer user_id); 
	
	/**
	 * 获取所有发布个人团信息	
	 * @param count		获取的条数
	 * @return
	 */
	public List<Persontuan> getPublicAllTuan(Integer count,Integer start);
	
	/**
	 * 修改个人发布的某条跟团信息
	 * @param persontuanId
	 * @param user_id
	 * @param persontuan
	 * @return
	 */
	public boolean updatePersonTuan(Integer persontuanId,Integer user_id,Persontuan persontuan);
	
	/**
	 * 删除我发布的某条跟团招聘信息
	 * @param persontuanId
	 * @param user_id
	 * @return
	 */
	public boolean deletePersonTuan(Integer persontuanId,Integer user_id);
}
