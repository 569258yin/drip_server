package com.agjsj.util;

import java.util.HashMap;

import net.sf.json.JSONObject;

import com.agjsj.entity.Resume;

public class JsonResumeUtil extends JsonAbstactDate{
	
	@Override
	public String createResumeJson(String requestCode, Resume resume, int Tag) {
		java.util.Map<String, String> map = new HashMap<String, String>();
		JSONObject jsonObject = new JSONObject();
		map.put("requestCode", requestCode);
		map.put("user_id", resume.getResumeId()+"");
		map.put("resume_id", resume.getUserId()+"");
		map.put("resume_name", resume.getResumeName()+"");
		map.put("resume_sex", resume.getResumeSex()+"");
		map.put("resume_age", resume.getResumeAge()+"");
		map.put("resume_nation", resume.getResumeNation()+"");
		map.put("resume_status", resume.getResumeStatus()+"");
		map.put("resume_place", resume.getResumePlace()+"");
		map.put("resume_school", resume.getResumeSchool()+"");
		map.put("resume_major", resume.getResumeMajor()+"");
		map.put("resume_education", resume.getResumeEducation()+"");
		map.put("resume_intention", resume.getResumeIntention()+"");
		map.put("resume_phone", resume.getResumePhone()+"");
		map.put("resume_email", resume.getResumeEmail()+"");
		map.put("resume_address", resume.getResumeAddress()+"");
		map.put("resume_strong", resume.getResumeStrong()+"");
		map.put("resume_honor", resume.getResumeHonor()+"");
		map.put("resume_experience", resume.getResumeExperience()+"");
		map.put("resume_myevaluate", resume.getResumeMyevaluate()+"");
		jsonObject.putAll(map);
		return jsonObject.toString();
	}
	
	
	@Override
	public Resume getResumeJson(JSONObject json_class) {
		Resume resume = new Resume();
		resume.setUserId(Integer.parseInt(json_class.getString("user_id")));
		resume.setResumeName(json_class.getString("resume_name"));
		resume.setResumeSex(Integer.parseInt(json_class.getString("resume_sex")));
		resume.setResumeAge(Integer.parseInt(json_class.getString("resume_age")));
		resume.setResumeNation(json_class.getString("resume_nation"));
		resume.setResumeStatus(json_class.getString("resume_status"));
		resume.setResumePlace(json_class.getString("resume_place"));
		resume.setResumeSchool(json_class.getString("resume_school"));
		resume.setResumeMajor(json_class.getString("resume_major"));
		resume.setResumeEducation(json_class.getString("resume_education"));
		resume.setResumeIntention(json_class.getString("resume_intention"));
		resume.setResumePhone(json_class.getString("resume_phone"));
		resume.setResumeEmail(json_class.getString("resume_email"));
		resume.setResumeAddress(json_class.getString("resume_address"));
		resume.setResumeStrong(json_class.getString("resume_strong"));
		resume.setResumeHonor(json_class.getString("resume_honor"));
		resume.setResumeExperience(json_class.getString("resume_experience"));
		resume.setResumeMyevaluate(json_class.getString("resume_myevaluate"));
		return resume;
	}
}
