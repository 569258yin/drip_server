package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Job;

public interface AppointJobDAO {
	
	/**
	 * 预约招聘
	 * @param appointJob
	 * @param user_id
	 * @param jobId
	 * @return
	 */
	public int sendAppointJob(Appointjob appointJob,Integer user_id,Integer jobId);
	
	/**
	 * 获取我的所有预约
	 * @param user_id
	 * @return
	 */
	public List<Job> getAppointJob(Integer user_id);
	
	/**
	 * 删除我的预约
	 * @param user_id
	 * @param jobId
	 * @return
	 */
	public boolean deleteAppointJob(Integer user_id,Integer jobId);
	
	public boolean deleteAppointJob(Integer jobId);
}
