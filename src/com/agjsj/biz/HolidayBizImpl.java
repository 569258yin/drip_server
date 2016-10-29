package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.HolidayDAO;
import com.agjsj.dao.HolidayDAOImpl;
import com.agjsj.entity.Holiday;

public class HolidayBizImpl implements HolidayBiz{

	@Override
	public int sendHoliday(Integer user_id, Holiday holiday) {
			HolidayDAO holidayDAO = new HolidayDAOImpl();
		return holidayDAO.sendHoliday(user_id, holiday);
	}

	@Override
	public List<Holiday> getPersonAllHoliday(Integer user_id) {
		HolidayDAO holidayDAO = new HolidayDAOImpl();
		return holidayDAO.getPersonAllHoliday(user_id);
	}

	@Override
	public List<Holiday> getPublicAllHoliday(Integer count, Integer start) {
		HolidayDAO holidayDAO = new HolidayDAOImpl();
		return holidayDAO.getPublicAllHoliday(count, start);
	}

	@Override
	public boolean updateHoliday(Integer holidayId, Integer user_id, Holiday holiday) {
		HolidayDAO holidayDAO = new HolidayDAOImpl();
		return holidayDAO.updateHoliday(holidayId, user_id, holiday);
	}

	@Override
	public boolean deleteHoliday(Integer holidayId, Integer user_id) {
		HolidayDAO holidayDAO = new HolidayDAOImpl();
		return holidayDAO.deleteHoliday(holidayId, user_id);
	}

}
