package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.JobDAO;
import com.agjsj.dao.JobDAOImpl;
import com.agjsj.entity.Job;

public class JobBizImpl implements JobBiz{

	@Override
	public int sendJob(Job job,Integer user_id) {
		JobDAO jobDAO = new JobDAOImpl();
		return jobDAO.sendJob(job, user_id);
	}

	@Override
	public List<Job> getPersonAllJob(Integer user_id) {
		JobDAO jobDAO = new JobDAOImpl();		
		return jobDAO.getPersonAllJob(user_id);
	}
	/*
	 * 获取我的所有兼职工作
	 * @see com.agjsj.biz.JobBiz#getPublicAllJob(Integer, Integer)
	 */

	@Override
	public List<Job> getPublicAllJob(Integer count, Integer start) {
		JobDAO jobDAO = new JobDAOImpl();
		return jobDAO.getPublicAllJob(count,start);
	}
	/*
	 *修改兼职招聘信息
	 */
	public boolean updateJob(Integer jobId,Integer user_id,Job job){
		JobDAO jobDAO = new JobDAOImpl();
		return jobDAO.updateJob(jobId, user_id, job);
	}

	@Override
	public boolean deleteJob(Integer jobId, Integer user_id) {
		JobDAO jobDAO = new JobDAOImpl();
		return jobDAO.deleteJob(jobId, user_id);
	}

	@Override
	public Job getJobById(int id) {
		JobDAO jobDAO = new JobDAOImpl();
		return jobDAO.getJobById(id);
	}


}
