package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Persontuan;

public class PersonTuanDAOImpl extends BaseHibernateDAO implements PersonTuanDAO{

	@Override
	public boolean sendPersonTuan(Persontuan persontuan, Integer user_id) {
		persontuan.setUserId(user_id);
		return  this.add(persontuan) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persontuan> getPersonAllTuan(Integer user_id) {
		String hql = "from Persontuan persontuan where persontuan.userId='"+user_id+"'";
		return this.getByHql(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persontuan> getPublicAllTuan(Integer count, Integer start) {
//		String hql = "from Persontuan";
//		return this.getPageList(count, start, hql);
		return this.getPageListByQBC(count, start, Persontuan.class, "PersontuanTime");
	}

	@Override
	public boolean updatePersonTuan(Integer persontuanId, Integer user_id,
			Persontuan persontuan) {
		persontuan.setPersontuanId(persontuanId);
		persontuan.setUserId(user_id); 
		return this.update(persontuan);
	}

	@Override
	public boolean deletePersonTuan(Integer persontuanId, Integer user_id) {
		AppointTuanDAO appointTuanDAO = new AppointTuanDAOImpl();
		appointTuanDAO.deleteAppointTuan(persontuanId);
		String hql = "from Persontuan persontuan where persontuan.persontuanId='"+persontuanId
				+"' and persontuanId.userId='"+user_id+"'";
		List list = this.getByHql(hql); 
		if (list.size() < 0) {
			return false;
		}else if(list.size() >= 0){
			return this.delete(list.get(0));
		}
		return false;
	}


}
