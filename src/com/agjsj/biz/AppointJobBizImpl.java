package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.AppointJobDAO;
import com.agjsj.dao.AppointJobDAOImpl;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Job;

public class AppointJobBizImpl implements AppointJobBiz {

	@Override
	public int sendAppointJob(Appointjob appointJob, Integer user_id, Integer jobId) {
			AppointJobDAO appointJobDAO = new AppointJobDAOImpl();
		return appointJobDAO.sendAppointJob(appointJob, user_id, jobId);
	}

	@Override
	public List<Job> getAppointJob(Integer user_id) {
		AppointJobDAO appointJobDAO = new AppointJobDAOImpl();
		return appointJobDAO.getAppointJob(user_id);
	}

	@Override
	public boolean deleteAppointJob(Integer user_id, Integer jobId) {
		AppointJobDAO appointJobDAO = new AppointJobDAOImpl();
		return appointJobDAO.deleteAppointJob(user_id, jobId);
	}

}
