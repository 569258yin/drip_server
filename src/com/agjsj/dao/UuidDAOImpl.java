package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Uuid;

public class UuidDAOImpl extends BaseHibernateDAO implements UuidDAO {

	@Override
	public void saveUUid(Uuid uuid) {
		
		super.add(uuid);
	}
	

	
	@Override
	public List<Uuid> getUuid() {
		String hql = "select uuid from Uuid uuid";
		return super.getByHql(hql);
	}



	@Override
	public void deleteUUid() {
		String hql = "delete Uuid where uuid >= 1";
		super.updateOrDeleteByHql(hql);
	}

}
