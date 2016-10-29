package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Holiday;

public class AppointHolidayDAOImpl extends BaseHibernateDAO implements AppointHolidayDAO{

	@Override
	public int sendAppointHoliday(Appointholiday appointHoliday,
			Integer user_id, Integer holidayId) {
		int tag = 0;
		String hql = "select appointholiday from Appointholiday appointholiday"
				+ " where appointholiday.userId='"+user_id
				+"' and appointholiday.holidayId='"+holidayId+"'";
		List list = this.getByHql(hql );
		if (list.size() > 0) {
			tag = -1;
		}else{
			if(this.add(appointHoliday)){
				tag = 1;
			}
		}
		return tag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Holiday> getAppointHoliday(Integer user_id) {
		String hql = "select holiday from Holiday holiday,Appointholiday appointholiday"
				+ " where appointholiday.userId='"+user_id+"' and appointholiday.holidayId = holiday.holidayId";
		return this.getByHql(hql);
	}

	@Override
	public boolean deleteAppointHoliday(Integer user_id, Integer holidayId) {
		String hql ="from Appointholiday appointholiday where appointholiday.userId='"+user_id
				+"' and appointholiday.holidayId='"+holidayId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() >= 0){
			return this.delete(list.get(0));
		}
		return false;
	}

	@Override
	public boolean deleteAppointHoliday(Integer holidayId) {
		String hql ="from Appointholiday appointholiday where appointholiday.holidayId='"+holidayId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}
	
	

}
