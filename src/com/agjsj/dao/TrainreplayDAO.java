package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Trainreplay;

public interface TrainreplayDAO {

	/**
	 * 添加评论		
	 * @param talkReplay  不需要ID
	 * @return
	 */
	public boolean addTrainReplay(Trainreplay trainReplay);
	
	/**
	 * 获取所有的评论
	 * @param talkId
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Trainreplay> getAllTrainReplay(Integer trainId,Integer count,Integer start);
}
