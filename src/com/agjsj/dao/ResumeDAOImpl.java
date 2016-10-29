package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Resume;


public class ResumeDAOImpl extends BaseHibernateDAO implements ResumeDAO{

	@Override
	public boolean sendResume(Resume resume) { 
		//String hql = "from User user where user.userName ='"+loginName +"'";
		System.out.println(resume.getUserId());
		String hql = "from Resume resume where resume.userId ='"+resume.getUserId()+"'";
		boolean bool = this.isExistByHql(hql);
		System.out.println(bool);
		System.out.println(resume.toString());
		if (bool) {
			return this.updateResume(resume, resume.getUserId());
		}
		return this.add(resume);
	}

	@Override
	public Resume getResume(Integer userId) {
		String hql = "from Resume resume where resume.userId ='"+userId+"'";
		try {
			List<Resume> list = this.getByHql(hql);
			if (list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteMyResume(Integer userId) {
		
		return this.delete(this.getResume(userId));
	}

	@Override
	public boolean updateResume(Resume resume,Integer userId) {
		Integer id = resume.getResumeId();
		boolean bool = false;
		bool = this.deleteMyResume(userId);
		if (bool) {
			resume.setResumeId(id);
			bool = this.add(resume);
		}
		return bool;
	}

}
