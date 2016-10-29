package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Appointtuan;
import com.agjsj.entity.Persontuan;

public interface AppointTuanBiz {

	/**
	 * 预约个人团
	 * 
	 * @param appointtuan
	 * @param user_id
	 * @param persontuanId
	 *            个人团的id
	 * @return
	 */
	public int sendAppointTuan(Appointtuan appointtuan, Integer user_id,
			Integer persontuanId);

	/**
	 * 获取我所预约的个人团
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Persontuan> getAppointTuan(Integer user_id);

	/**
	 * 删除我预约的个人团
	 * 
	 * @param user_id
	 * @param persontuanId
	 *            个人团的id
	 * @return
	 */
	public boolean deleteAppointTuan(Integer user_id, Integer persontuanId);
}
