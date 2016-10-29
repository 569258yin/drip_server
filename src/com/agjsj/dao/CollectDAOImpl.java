package com.agjsj.dao;

import java.util.ArrayList;
import java.util.List;

import com.agjsj.entity.Collect;
import com.agjsj.entity.Job;

public class CollectDAOImpl extends BaseHibernateDAO implements CollectDAO{

	@Override
	public boolean addCollect(Integer user_id, Integer tag, Integer id) {
		Collect c = null;
		if(tag == 1){
			String hql = "from Collect collect where collect.userId='"+user_id
					+"' and collect.jobId='"+id+"'";
//			System.out.println("this.get");
			if ( this.getByHql(hql).size() > 0) {
				return true;
			}
			c = new Collect(user_id, id, null, null);
		}else if(tag == 2){
			String hql = "from Collect collect where collect.userId='"+user_id
					+"' and collect.holidayId='"+id+"'";
			if ( this.getByHql(hql).size() > 0) {
				return true;
			}
			c = new Collect(user_id, null, id, null);
		}else if(tag == 3){
			String hql = "from Collect collect where collect.userId='"+user_id
					+"' and collect.trainId ='"+id+"'";
			if (this.getByHql(hql).size() > 0) {
				return true;
			}
			c = new Collect(user_id, null, null, id);
		}
		return this.add(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getCollectJob(Integer user_id, Integer tag) {
		/*from Persontuan persontuan where persontuan.userId='"+user_id+"'
		 */
		if(tag == 1){
			String hql = "select job from Job job,Collect collect"
					+ " where collect.userId='"+user_id+"' and collect.jobId = job.jobId";
			return this.getByHql(hql);
		}else if(tag == 2){
			String hql = "select holiday from Holiday holiday,Collect collect"
					+ " where collect.userId='"+user_id+"' and collect.holidayId = holiday.holidayId";
			return this.getByHql(hql);
		}else if(tag == 3){
			String hql = "select train from Train train,Collect collect"
					+ " where collect.userId='"+user_id+"' and collect.trainId = train.trainId";
			return this.getByHql(hql);
		}
		return null;
	}

	@Override
	public boolean deleteCollect(Integer user_id, Integer collectId,Integer tag) {
		Collect c = new Collect();
		if(tag == 1){
			String hql = "select collect from Collect collect"
					+ " where collect.userId='"+user_id+"' and collect.jobId ='"+collectId+"'";
			c =  (Collect) this.getByHql(hql).get(0);
		}else if(tag == 2){
			String hql = "select collect from Collect collect"
					+ " where collect.userId='"+user_id+"' and collect.holidayId ='"+collectId+"'";
			c =  (Collect) this.getByHql(hql).get(0);
		}else if(tag == 3){
			String hql = "select collect from Collect collect"
					+ " where collect.userId='"+user_id+"' and collect.trainId ='"+collectId+"'";
			c =  (Collect) this.getByHql(hql).get(0);
		}
		return this.delete(c);
	}

	@Override
	public boolean deleteCollect(Integer id, Integer tag) {
		Collect c = new Collect();
		if(tag == 1){
			String hql = "select collect from Collect collect"
					+ " where collect.jobId ='"+id+"'";
			if (this.getByHql(hql).size() > 0) {
				c =  (Collect) this.getByHql(hql).get(0);
			}
		}else if(tag == 2){
			String hql = "select collect from Collect collect"
					+ " where collect.holidayId ='"+id+"'";
			if (this.getByHql(hql).size() > 0) {
				c =  (Collect) this.getByHql(hql).get(0);
			}
		}else if(tag == 3){
			String hql = "select collect from Collect collect"
					+ " where collect.trainId ='"+id+"'";
			if (this.getByHql(hql).size() > 0) {
				c =  (Collect) this.getByHql(hql).get(0);
			}
		}
		return this.delete(c);
	}

}
