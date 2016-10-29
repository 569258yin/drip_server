package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

/**
 * 对每日推荐进行数据库的操作
 * 需要三种不同的对象数据
 * 对数据库操作分为三种   不同 tag
 * 向客户端传递json时可直接传递
 * @author yh
 *
 */
public interface ReccomDAO {
	/**
	 * 获取推荐的工作
	 * @return
	 */
	public List<Job> getListJob();
	/**
	 * 获取推荐的旅游
	 * @return
	 */
	public List<Holiday> getListHoliday();
	/**
	 * 获取推荐的教育培训
	 * @return
	 */
	public List<Train> getListTrain();
}
