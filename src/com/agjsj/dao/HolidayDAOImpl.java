package com.agjsj.dao;

import java.io.File;
import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.util.HttpImageUtil;

public class HolidayDAOImpl extends BaseHibernateDAO implements HolidayDAO{

	@Override
	public int sendHoliday(Integer user_id, Holiday holiday) {
		holiday.setUserId(user_id);
		Holiday myholiday = (Holiday) this.addObject(holiday);
		if (myholiday != null) {
			System.out.println(myholiday.getHolidayId());
			return myholiday.getHolidayId();
		}
		return 0 ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Holiday> getPersonAllHoliday(Integer user_id) {
		String hql = "from Holiday holiday where holiday.userId='"+user_id+"'";
		return this.getByHql(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Holiday> getPublicAllHoliday(Integer count, Integer start) {
		//		String hql = "from Holiday";
		//		return this.getPageList(count, start, hql);
		return this.getPageListByQBC(count, start, Holiday.class,"holidayStartdate");
	}

	@Override
	public boolean updateHoliday(Integer holidayId, Integer user_id, Holiday holiday) {
		holiday.setHolidayId(holidayId);
		holiday.setUserId(user_id); 
		return this.update(holiday);
	}

	@Override
	public boolean deleteHoliday(Integer holidayId, Integer user_id) {
		try {
			AppointHolidayDAO appointHolidayDAO = new AppointHolidayDAOImpl();
			CollectDAO c;
			appointHolidayDAO.deleteAppointHoliday(holidayId);
			c = new CollectDAOImpl();
			c.deleteCollect(holidayId, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String hql = "from Holiday holiday where holiday.holidayId='"+holidayId
				+"' and holiday.userId='"+user_id+"'";
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

}
