package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

public interface SearchBiz {
	/**
	 * 在工作中搜索与给定字符串匹配的
	 * @param str
	 * @return
	 */
	public List<Job> serchJob(String str);
	
	/**
	 * 在度假中搜索与给定字符串匹配的
	 * @param str
	 * @return
	 */
	public List<Holiday> serchHoliday(String str);
	
	
	/**
	 * 在教育培训中
	 * @param str
	 * @return
	 */
	public List<Train> searchTrain(String str);
}
