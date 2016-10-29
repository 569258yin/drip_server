package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.HolidayreplayDAO;
import com.agjsj.dao.HolidayreplayDAOImpl;
import com.agjsj.entity.Holidayreplay;

public class HolidayreplayBizImpl implements HolidayreplayBiz{

	@Override
	public boolean addHolidayReplay(Holidayreplay holidayReplay) {
		HolidayreplayDAO holidayreplayDAO = new HolidayreplayDAOImpl();
		return holidayreplayDAO.addHolidayReplay(holidayReplay);
	}

	@Override
	public List<Holidayreplay> getAllHolidayReplay(Integer holidayId,
			Integer count, Integer start) {
		HolidayreplayDAO holidayreplayDAO = new HolidayreplayDAOImpl();
		return holidayreplayDAO.getAllHolidayReplay(holidayId, count, start);
	}

}
