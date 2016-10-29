package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

public interface ReccomBiz {
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
