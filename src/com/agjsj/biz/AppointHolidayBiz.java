package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Holiday;

public interface AppointHolidayBiz {

	/**
	 * 预约预约的旅游
	 * @param appointHoliday
	 * @param user_id
	 * @param holidayId
	 * @return
	 */
	public int sendAppointHoliday(Appointholiday appointHoliday,Integer user_id,Integer holidayId);
	
	/**
	 * 获取我的所有预约度假
	 * @param user_id
	 * @return
	 */
	public List<Holiday> getAppointHoliday(Integer user_id);
	
	/**
	 * 删除我指定的预约的度假
	 * @param user_id
	 * @param holidayId
	 * @return
	 */
	public boolean deleteAppointHoliday(Integer user_id,Integer holidayId);
}
