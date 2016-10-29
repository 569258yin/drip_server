package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Appointtuan;
import com.agjsj.entity.Persontuan;

public class AppointTuanDAOImpl extends BaseHibernateDAO implements AppointTuanDAO{

	@Override
	public int sendAppointTuan(Appointtuan appointtuan, Integer user_id,
			Integer persontuanId) {
		int tag = 0;
		String hql = "select appointtuan from Appointtuan appointtuan"
				+" where appointtuan.userId='"+user_id
				+"' and appointtuan.persontuanId='"+persontuanId+"'";
		List list = this.getByHql(hql);
		System.out.println(list.size());
		System.out.println(tag+"");
		if (list.size() > 0) {
			tag = -1;
		}else{
			if(this.add(appointtuan)){
				tag = 1;
			}
		}
		return tag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persontuan> getAppointTuan(Integer user_id) {
		String hql = "select persontuan from Persontuan persontuan,Appointtuan appointtuan"
				+ " where appointtuan.userId='"+user_id+"' and appointtuan.persontuanId = persontuan.persontuanId";
		return this.getByHql(hql);
	}

	@Override
	public boolean deleteAppointTuan(Integer user_id, Integer persontuanId) {
		String hql ="from Appointtuan appointtuan where appointtuan.userId='"+user_id
				+"' and appointtuan.persontuanId='"+persontuanId+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}

	@Override
	public boolean deleteAppointTuan(Integer persontuanId) {
		String hql ="from Appointtuan appointtuan where appointtuan.persontuanId='"+persontuanId+"'";
		List list = this.getByHql(hql); 
		System.out.println(list.size());
		if (list.size() < 0) {
			return false;
		}else if(list.size() > 0){
			return this.delete(list.get(0));
		}
		return false;
	}

}
