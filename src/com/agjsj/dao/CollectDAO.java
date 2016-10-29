package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

/**
 * 我的收藏数据库操作
 * @author yh
 *
 */
public interface CollectDAO {
	/**
	 * 向数据库中添加我的收藏
	 * @param user_id	收藏用户
	 * @param tag		标志是要收藏的哪种的信息
	 * @param id		要收藏的id
	 * @return			
	 */
	public boolean addCollect(Integer user_id,Integer tag,Integer id);
	
	/**
	 * 获取我的收藏
	 * @param user_id	用户
	 * @param tag     标志
	 * @return
	 */
	public List<Object> getCollectJob(Integer user_id,Integer tag);
	
	/**
	 * 删除我的收藏
	 * @param user_id
	 * @param collectId
	 * @return
	 */
	public boolean deleteCollect(Integer user_id,Integer collectId,Integer tag);
	

	/**
	 * 删除我的收藏
	 * @param user_id
	 * @param collectId
	 * @return
	 */
	public boolean deleteCollect(Integer id,Integer tag);
	
}
