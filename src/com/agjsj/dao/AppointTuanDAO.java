package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Appointtuan;
import com.agjsj.entity.Persontuan;
/**
 * 个人开团的数据库操作
 * @author yh
 *
 */

public interface AppointTuanDAO {
	/**
	 * 预约培训
	 * @param appointtuan
	 * @param user_id
	 * @param persontuanId  个人团的id
	 * @return
	 */
	public int sendAppointTuan(Appointtuan appointtuan,Integer user_id,Integer persontuanId);
	
	/**
	 * 获取我的所有预约培训
	 * @param user_id
	 * @return
	 */
	public List<Persontuan> getAppointTuan(Integer user_id);
	
	/**
	 * 删除我的预约培训
	 * @param user_id
	 * @param persontuanId	个人团的id
	 * @return
	 */
	public boolean deleteAppointTuan(Integer user_id,Integer persontuanId);
	
	public boolean deleteAppointTuan(Integer persontuanId);
}
