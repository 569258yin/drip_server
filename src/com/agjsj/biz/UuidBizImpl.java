package com.agjsj.biz;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.agjsj.dao.UuidDAO;
import com.agjsj.dao.UuidDAOImpl;
import com.agjsj.entity.Uuid;
import com.agjsj.servlet.Application;

public class UuidBizImpl implements UuidBiz{

	@Override
	public void saveUUid() {
		UuidDAO dao = new UuidDAOImpl();
		dao.deleteUUid();
		Set set = Application.userMap.keySet();
		Uuid uuid;
		for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
			String key = (String) iterator2.next();
			uuid = new Uuid(key, Application.userMap.get(key));
			dao.saveUUid(uuid);
		}
	}

	@Override
	public void getUuid() {
		UuidDAO dao = new UuidDAOImpl();
		List<Uuid> list = dao.getUuid();
		for (int i = 0; i <list.size(); i++) {
			Application.userMap.put(list.get(i).getLoginname(), list.get(i).getNewvalus());
		}
	}

}
