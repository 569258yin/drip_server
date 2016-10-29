package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

public class SearchDAOImpl extends BaseHibernateDAO implements SerachDAO{

	@Override
	public List<Job> serchJob(String str) {
//		String hql = "FROM Table AS t WHERE t.field LIKE :param";
//		Query query = getSession().createQuery(hql);
//		query.setString("param", "%" + str + "%");
//		query.list();
		String hql = "from Job job where job.jobName LIKE '%"+str+"%'";
		return getByHql(hql);
	}

	@Override
	public List<Holiday> serchHoliday(String str) {
		String hql = "from Holiday holiday where holiday.holidayName LIKE '%"+str+"%'";
		return getByHql(hql);
	}

	@Override
	public List<Train> searchTrain(String str) {
		String hql = "from Train train where train.courseName LIKE '%"+str+"%'";
		return getByHql(hql);
	}

}
