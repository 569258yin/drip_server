package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Job;
/**
 * 兼职招聘数据库操作
 * @author yh
 *
 */
public interface JobDAO {
	
	/**
	 * 发布招聘
	 * @param job
	 * @param user_id
	 * @return
	 */
	public int sendJob(Job job,Integer user_id);
	
	/**
	 * 获取个人发布招聘的所有信息
	 * @param user_id
	 * @return
	 */
	public List<Job> getPersonAllJob(Integer user_id); 
	
	/**
	 * 获取所有发布信息	
	 * @param count		获取的条数
	 * @return
	 */
	public List<Job> getPublicAllJob(Integer count,Integer start);
	
	/**
	 * 修改个人发布的某条招聘信息
	 * @param jobId
	 * @param user_id
	 * @param job
	 * @return
	 */
	public boolean updateJob(Integer jobId,Integer user_id,Job job);
	
	/**
	 * 删除我发布的某条招聘信息
	 * @param jobId
	 * @param user_id
	 * @return
	 */
	public boolean deleteJob(Integer jobId,Integer user_id);
	
	/**
	 * 获取单个工作信息
	 * @param id
	 * @return
	 */
	public Job getJobById(int id);
}
