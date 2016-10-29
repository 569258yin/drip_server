package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

@SuppressWarnings("unchecked")
public class ReccomDAOImpl extends BaseHibernateDAO implements ReccomDAO{

	@Override
	public List<Job> getListJob() {
		String hql = "select job from Job job,Reccom reccom"
				+ " where reccom.tag=1 and reccom.jobId = job.jobId";
		return this.getByHql(hql);
	}

	@Override
	public List<Holiday> getListHoliday() {
		String hql = "select holiday from Holiday holiday,Reccom reccom"
				+ " where reccom.tag=2 and reccom.holidayId = holiday.holidayId";
		return this.getByHql(hql);
	}

	@Override
	public List<Train> getListTrain() {
		String hql = "select train from Train train,Reccom reccom"
				+ " where reccom.tag=3 and reccom.trainId = train.trainId";
		return this.getByHql(hql);
	}

}
