package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Job;

public class AppointJobDAOImpl extends BaseHibernateDAO implements AppointJobDAO{

	@Override
	public int sendAppointJob(Appointjob appointJob, Integer user_id,
			Integer jobId) {
		int tag = 0;
		String hql = "select appointjob from Appointjob appointjob"
				+ " where appointjob.userId='"+user_id
				+"' and appointjob.jobId='"+jobId+"'";
		List list = this.getByHql(hql);
		if (list.size() > 0) {
			tag = -1;
		}else{
			if(this.add(appointJob)){
				tag = 1;
			}
		}
		return tag;
	}

	@Override
	public List<Job> getAppointJob(Integer user_id) {
		String hql = "select job from Job job,Appointjob appointjob"
				+ " where appointjob.userId='"+user_id+"' and appointjob.jobId = job.jobId";
		return this.getByHql(hql);
	}

	@Override
	public boolean deleteAppointJob(Integer user_id, Integer jobId) {
		String hql ="from Appointjob appointjob where appointjob.userId='"+user_id
				+"' and appointjob.jobId='"+jobId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}

	@Override
	public boolean deleteAppointJob(Integer jobId) {
		String hql ="from Appointjob appointjob where appointjob.jobId='"+jobId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}

}
