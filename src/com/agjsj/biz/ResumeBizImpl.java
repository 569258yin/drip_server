package com.agjsj.biz;

import com.agjsj.dao.ResumeDAO;
import com.agjsj.dao.ResumeDAOImpl;
import com.agjsj.entity.Resume;

public class ResumeBizImpl implements ResumeBiz{

	@Override
	public boolean registerResume(Resume resume) {
		ResumeDAO resumeDAO =  new ResumeDAOImpl();
		
		return resumeDAO.sendResume(resume);
	}

	@Override
	public Resume getResumeByUserId(Integer userId) {
		ResumeDAO resumeDAO = new ResumeDAOImpl();
		return resumeDAO.getResume(userId);
	}

	@Override
	public boolean deleteResumeByUserId(Integer userId) {
		ResumeDAO resumeDAO = new ResumeDAOImpl();
		return resumeDAO.deleteMyResume(userId);
	}

	@Override
	public boolean updateResumeByUserId(Resume resume,Integer userId) {
		ResumeDAO resumeDAO = new ResumeDAOImpl();
		return resumeDAO.updateResume(resume,userId);
	}


}
