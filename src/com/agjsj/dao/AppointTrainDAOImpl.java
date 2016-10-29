package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Train;

public class AppointTrainDAOImpl extends BaseHibernateDAO implements AppointTrainDAO{

	@Override
	public int sendAppointTrain(Appointtrain appointTrain, Integer user_id,
			Integer trainId) {
		int tag = 0;
		String hql = "select appointtrain from Appointtrain appointtrain"
				+ " where appointtrain.userId='"+user_id
				+"' and appointtrain.trainId='"+trainId+"'";
		List list = this.getByHql(hql);
		System.out.println(list.size());
		System.out.println(tag+"");
		if (list.size() > 0) {
			tag = -1;
		}else{
			if(this.add(appointTrain)){
				tag = 1;
			}
		}
		return tag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Train> getAppointTrain(Integer user_id) {
		String hql = "select train from Train train,Appointtrain appointtrain"
				+ " where appointtrain.userId='"+user_id+"' and appointtrain.trainId = train.trainId";
		return this.getByHql(hql);
	}

	@Override
	public boolean deleteAppointTrain(Integer user_id, Integer trainId) {
		String hql ="from Appointtrain appointtrain where appointtrain.userId='"+user_id
				+"' and appointtrain.trainId='"+trainId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}

	@Override
	public boolean deleteAppointTrain(Integer trainId) {
		String hql ="from Appointtrain appointtrain where appointtrain.trainId='"+trainId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}

}
