package com.agjsj.dao;

public class ImageDAOImpl extends BaseHibernateDAO implements ImageDAO{

	@Override
	public boolean addUserIcon(String url, Integer id) {
		boolean boolPerson = true;
		boolean boolUser = false;
		String hql2 = "from Persontuan persontuan where persontuan.userId='"+id+"'";
		if (this.getByHql(hql2).size() > 0) {
			String hql1 = "update Persontuan persontuan set persontuan.PersontuanUsericon='"+url
					+"' where persontuan.userId='"+id+"'";
			boolPerson = this.updateOrDeleteByHql(hql1);
		}
		String hql = "update User user set user.userIcon='"+url
				+"' where user.userId='"+id+"'";
		boolUser = this.updateOrDeleteByHql(hql);
		if (boolUser && boolPerson) {
			return true;
		}else if(boolPerson == false){
			System.out.println("插入个人开团头像失败");
			return false;
		}else{
			System.out.println("插入个人头像失败");
			return false;
		}
	}

	@Override
	public boolean addJobIcon(String url, Integer id) {
		String hql = "update Job job set job.jobIcon='"+url
				+"' where job.jobId='"+id+"'";
		return this.updateOrDeleteByHql(hql);
	}

	@Override
	public boolean addHolidayIcon(String url, Integer id) {
		String hql = "update Holiday holiday set holiday.holidayIcon='"+url
				+"' where holiday.holidayId='"+id+"'";
		return this.updateOrDeleteByHql(hql);
	}

	@Override
	public boolean addTrainIcon(String url, Integer id) {
		String hql = "update Train train set train.trainIcon='"+url
				+"' where train.trainId='"+id+"'";
		return this.updateOrDeleteByHql(hql);
	}

	@Override
	public boolean addTalkIcon(String url, Integer id) {
		String hql = "update Talk talk set talk.talkIcon='"+url
				+"' where talk.talkId='"+id+"'";
		return this.updateOrDeleteByHql(hql);
	}
	


}
