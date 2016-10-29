package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;

/**
 * 发布度假数据库操作接口
 * @author yh
 *
 */
public interface HolidayDAO {
	
	/**
	 * 发布旅游度假信息
	 * @param user_id
	 * @param holiday
	 * @return
	 */
	public int sendHoliday(Integer user_id,Holiday holiday);
	
	/**
	 * 获取个人发布旅游的所有信息
	 * @param user_id
	 * @return
	 */
	public List<Holiday> getPersonAllHoliday(Integer user_id); 
	
	/**
	 * 获取所有发布旅游的信息	
	 * @param count		获取的条数
	 * @param start 	起始位置
	 * @return
	 */
	public List<Holiday> getPublicAllHoliday(Integer count,Integer start);
	
	/**
	 * 修改个人发布的某条旅游度假信息
	 * @param holidayId
	 * @param user_id
	 * @param holiday
	 * @return
	 */
	public boolean updateHoliday(Integer holidayId,Integer user_id,Holiday holiday);
	
	/**
	 * 删除我发布的某条旅游信息
	 * @param holidayId
	 * @param user_id
	 * @return
	 */
	public boolean deleteHoliday(Integer holidayId,Integer user_id);
	
}
