package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Talkreplay;

public interface JobreplayDAO {
	
	/**
	 * 添加评论		
	 * @param talkReplay  不需要ID
	 * @return
	 */
	public boolean addJobReplay(Jobreplay jobReplay);
	
	/**
	 * 获取所有的评论
	 * @param talkId
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Jobreplay> getAllJobReplay(Integer jobId,Integer count,Integer start);
}
