package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Train;

public interface TrainBiz {
	/**
	 * 发布培训
	 * @param job
	 * @param user_id
	 * @return
	 */
	public int sendTrain(Train train,Integer user_id);
	
	/**
	 * 获取个人发布培训的所有信息
	 * @param user_id
	 * @return
	 */
	public List<Train> getPersonAllTrain(Integer user_id); 
	
	/**
	 * 获取所有发布教育培训信息
	 * 分页获取	
	 * @param count		获取的条数
	 * @param start     开始位置
	 * @return
	 */
	public List<Train> getPublicAllTrain(Integer count,Integer start);
	
	/**
	 * 修改个人发布的某条教育培训信息
	 * @param jobId
	 * @param user_id
	 * @param train
	 * @return
	 */
	public boolean updateTrain(Integer trainId,Integer user_id,Train train);
	
	/**
	 * 删除我发布的某条教育培训信息
	 * @param persontuanId
	 * @param trainId
	 * @return
	 */
	public boolean deleteTrain(Integer trainId,Integer user_id);

}
