package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Holidayreplay;

public class HolidayreplayDAOImpl extends BaseHibernateDAO implements HolidayreplayDAO{

	@Override
	public boolean addHolidayReplay(Holidayreplay holidayReplay) {
		// TODO Auto-generated method stub
		return this.add(holidayReplay);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Holidayreplay> getAllHolidayReplay(Integer holidayId,
			Integer count, Integer start) {
		return this.getPageListByQBC(count, start, Holidayreplay.class,
				"holidayreplayTime", "holidayId", holidayId);
	}

}
