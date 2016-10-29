package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Optuanreplay;
import com.agjsj.entity.Talkreplay;

public interface OpentuanreplayDAO {
	
	/**
	 * 添加评论		
	 * @param talkReplay  不需要ID
	 * @return
	 */
	public boolean addOptuanReplay(Optuanreplay optuanreplay);
	
	/**
	 * 获取所有的评论
	 * @param talkId
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Optuanreplay> getAllOptuanReplay(Integer opentuanId,Integer count,Integer start);
}
