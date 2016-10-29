package com.agjsj.dao;

import java.io.File;
import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Train;
import com.agjsj.util.HttpImageUtil;

public class TrainDAOImpl extends BaseHibernateDAO implements TrainDAO{

	@Override
	public int sendTrain(Train train, Integer user_id) {
		train.setUserId(user_id);
		Train mytrain = (Train) this.addObject(train);
		if (mytrain != null) {
			System.out.println(mytrain.getTrainId());
			return mytrain.getTrainId();
		}
		return  0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Train> getPersonAllTrain(Integer user_id) {
		String hql = "from Train train where train.userId='"+user_id+"'";
		return this.getByHql(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Train> getPublicAllTrain(Integer count, Integer start) {
//		String hql = "from Train";
//		return this.getPageList(count, start, hql);
		return this.getPageListByQBC(count, start, Train.class, "trainStartdate");
	}

	@Override
	public boolean updateTrain(Integer trainId, Integer user_id, Train train) {
		train.setTrainId(trainId);
		train.setUserId(user_id); 
		return this.update(train);
	}

	@Override
	public boolean deleteTrain(Integer trainId, Integer user_id) {
		AppointTrainDAO appointTrainDAO = new AppointTrainDAOImpl();
		appointTrainDAO.deleteAppointTrain(trainId);
		CollectDAO c = new CollectDAOImpl();
		c.deleteCollect(trainId, 3);
		String hql = "from Train train where train.trainId='"+trainId
				+"' and train.userId='"+user_id+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() >= 0){
			/*
			 * 删除发布的图片
			 */
			final String path = HttpImageUtil.getLocalImageUrl(((Holiday)list.get(0))
					.getHolidayIcon());
			new Thread(){
				public void run() {
					File file = new File(path);
					if (file.exists()) {
						file.delete();
					}
				};
			}.start();
			return this.delete(list.get(0));
		}
		return false;
	}

}
