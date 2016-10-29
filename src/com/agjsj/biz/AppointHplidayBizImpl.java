package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.AppointHolidayDAO;
import com.agjsj.dao.AppointHolidayDAOImpl;
import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Holiday;

public class AppointHplidayBizImpl implements AppointHolidayBiz{

	@Override
	public int sendAppointHoliday(Appointholiday appointHoliday, Integer user_id, Integer holidayId) {
		AppointHolidayDAO appointHolidayDAO = new AppointHolidayDAOImpl();
		return appointHolidayDAO.sendAppointHoliday(appointHoliday, user_id, holidayId);
	}



	@Override
	public boolean deleteAppointHoliday(Integer user_id, Integer holidayId) {
		AppointHolidayDAO appointHolidayDAO = new AppointHolidayDAOImpl();
		return appointHolidayDAO.deleteAppointHoliday(user_id, holidayId);
	}



	@Override
	public List<Holiday> getAppointHoliday(Integer user_id) {
		AppointHolidayDAO appointHolidayDAO = new AppointHolidayDAOImpl();
		return appointHolidayDAO.getAppointHoliday(user_id);
	}

}
