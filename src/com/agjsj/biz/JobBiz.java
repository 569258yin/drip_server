package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Job;

public interface JobBiz {
	
	/**
	 * 发送兼职招聘
	 * @return
	 */
	public int sendJob(Job job,Integer user_id);
	
	/**
	 * 返回用户的所有发布的招聘
	 * @param user_id
	 * @return
	 */
	public List<Job> getPersonAllJob(Integer user_id);
	/**
	 * 
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Job> getPublicAllJob(Integer count,Integer start);
	
	/*
	 * 修改兼职招聘信息
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
	 * 获取单个工作
	 * @param id
	 * @return
	 */
	public Job getJobById(int id);
}
