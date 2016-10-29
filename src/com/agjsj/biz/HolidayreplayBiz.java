package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Holidayreplay;

public interface HolidayreplayBiz {
	/**
	 * 添加评论		
	 * @param talkReplay  不需要ID
	 * @return
	 */
	public boolean addHolidayReplay(Holidayreplay holidayReplay);

	/**
	 * 获取所有的评论
	 * @param talkId
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Holidayreplay> getAllHolidayReplay(Integer holidayId,Integer count,Integer start);
}
