package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.PersonTuanDAO;
import com.agjsj.dao.PersonTuanDAOImpl;
import com.agjsj.entity.Persontuan;

public class PersonTuanBizImpl implements PersonTuanBiz {

	@Override
	public boolean sendPersonTuan(Persontuan persontuan, Integer user_id) {
		PersonTuanDAO personTuanDAO = new PersonTuanDAOImpl();
		return personTuanDAO.sendPersonTuan(persontuan, user_id);

	}

	@Override
	public List<Persontuan> getPersonAllTuan(Integer user_id) {
		PersonTuanDAO personTuanDAO = new PersonTuanDAOImpl();
		return personTuanDAO.getPersonAllTuan(user_id);
	}

	@Override
	public List<Persontuan> getPublicAllTuan(Integer count, Integer start) {
		PersonTuanDAO personTuanDAO = new PersonTuanDAOImpl();
		return personTuanDAO.getPublicAllTuan(count, start);
	}

	@Override
	public boolean updatePersonTuan(Integer persontuanId, Integer user_id,
			Persontuan persontuan) {
		PersonTuanDAO personTuanDAO = new PersonTuanDAOImpl();
		return personTuanDAO
				.updatePersonTuan(persontuanId, user_id, persontuan);
	}

	@Override
	public boolean deletePersonTuan(Integer persontuanId, Integer user_id) {
		PersonTuanDAO personTuanDAO = new PersonTuanDAOImpl();
		return personTuanDAO.deletePersonTuan(persontuanId, user_id);
	}

}
