package com.agjsj.biz;


import java.util.List;

import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Train;

public interface AppointTrainBiz {

	/**
	 * 预约培训
	 * @param appointJob
	 * @param user_id
	 * @param jobId
	 * @return
	 */
	public int sendAppointTrain(Appointtrain appointTrain,Integer user_id,Integer trainId);
	
	/**
	 * 获取我的所有预约培训
	 * @param user_id
	 * @return
	 */
	public List<Train> getAppointTrain(Integer user_id);
	
	/**
	 * 删除我的预约培训
	 * @param user_id
	 * @param jobId
	 * @return
	 */
	public boolean deleteAppointTrain(Integer user_id,Integer trainId);
}
