package com.agjsj.dao;

import java.io.File;
import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.util.HttpImageUtil;

public class JobDAOImpl extends BaseHibernateDAO implements JobDAO{


	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getPersonAllJob(Integer user_id) {
	//	String hql = "from User user where user.userName ='"+loginName+"'"
	//			+" AND user.userPsw ='"+loginPwd+"'";
		String hql = "from Job job where job.userId='"+user_id+"'";
		return this.getByHql(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getPublicAllJob(Integer count, Integer start) {
//		String hql = "from Job";
//		return this.getPageList(count, start, hql);
		return this.getPageListByQBC(count, start, Job.class, "jobStartdate");
	}

	@Override
	public boolean updateJob(Integer jobId, Integer user_id, Job job) {
		job.setJobId(jobId);
		job.setUserId(user_id); 
		return this.update(job);
	}

	@Override
	public boolean deleteJob(Integer jobId, Integer user_id) {
		/*
		 * 级联操作删除
		 */
		AppointJobDAO appointJobDAO = new AppointJobDAOImpl();
		appointJobDAO.deleteAppointJob(jobId);
		CollectDAO c = new CollectDAOImpl();
		c.deleteCollect(jobId, 1);
		String hql = "from Job job where job.jobId='"+jobId
				+"' and job.userId='"+user_id+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() >= 0){
			/*
			 * 删除发布的图片
			 */
			final String path = HttpImageUtil.getLocalImageUrl(((Holiday)list.get(0))
					.getHolidayIcon());
			new Thread(){
				public void run() {
					File file = new File(path);
					if (file.exists()) {
						file.delete();
					}
				};
			}.start();
			return this.delete(list.get(0));
		}
		return false;
	}

	@Override
	public int sendJob(Job job, Integer user_id) {
		job.setUserId(user_id);
		Job myjob = (Job) this.addObject(job);
		if (myjob != null) {
			System.out.println(myjob.getJobId());
			return myjob.getJobId();
		}
		return 0 ;
	}

	@Override
	public Job getJobById(int id) {
		return (Job) this.get(Job.class, id);
	}

	
	
}
