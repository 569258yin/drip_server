package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.entity.Job;

public class JsonJobUtil extends JsonAbstactDate{
	
	
	public Job getJobJson(JSONObject jsonObject) {
		Job job = new Job();
		job.setJobName(jsonObject.getString("jobName"));
		job.setJobType(Integer.parseInt(jsonObject.getString("jobType")));
		job.setJobRequire(jsonObject.getString("jobRequire"));
		job.setJobDescription(jsonObject.getString("jobDescription"));
		job.setJobNotice(jsonObject.getString("jobNotice"));
		job.setJobMoney(jsonObject.getString("jobMoney"));
		job.setJobPeriod(Integer.parseInt(jsonObject.getString("jobPeriod")));
		job.setJobNumber(Integer.parseInt(jsonObject.getString("jobNumber")));
		job.setJobAddress(jsonObject.getString("jobAddress"));
		job.setJobAddressinfo(jsonObject.getString("jobAddressinfo"));
		job.setJobStartdate(jsonObject.getString("jobStartdate"));
		job.setJobEnddate(jsonObject.getString("jobEnddate"));
		job.setJobTimes(jsonObject.getString("jobTimes"));
		job.setJobLinkman(jsonObject.getString("jobLinkman"));
		job.setJobPhone(jsonObject.getString("jobPhone"));
//		job.setJobIcon(jsonObject.getString("jobIcon"));
		job.setJobState(0);
		return job;
	}

	public String createJobListJson(List<Job> list) {
		return createJobJSONListJson(list).toString();
	}
	
	public JSONObject createJobJSONListJson(List<Job> list){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject;

		} else {
			jsonObject.put("Tag", "1");
			Job job = null;
			for (int i = 0; i < list.size(); i++) {
				job = list.get(i);
				JSONObject jsonObject2 = getJobToJsonObject(job);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject;
		}
	}

	public JSONObject getJobToJsonObject(Job job) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("jobId", job.getJobId());
		jsonObject.put("user_id", job.getUserId());
		jsonObject.put("jobName", job.getJobName() + "");
		jsonObject.put("jobType", job.getJobType() + "");
		jsonObject.put("jobRequire", job.getJobRequire() + "");
		jsonObject.put("jobDescription", job.getJobDescription() + "");
		jsonObject.put("jobNotice", job.getJobNotice() + "");
		jsonObject.put("jobMoney", job.getJobMoney() + "");
		jsonObject.put("jobPeriod", job.getJobPeriod() + "");
		jsonObject.put("jobNumber", job.getJobNumber() + "");
		jsonObject.put("jobAddress", job.getJobAddress() + "");
		jsonObject.put("jobAddressinfo", job.getJobAddressinfo() + "");
		jsonObject.put("jobStartdate", job.getJobStartdate() + "");
		jsonObject.put("jobEnddate", job.getJobEnddate() + "");
		jsonObject.put("jobTimes", job.getJobTimes() + "");
		jsonObject.put("jobLinkman", job.getJobLinkman() + "");
		jsonObject.put("jobPhone", job.getJobPhone() + "");
		jsonObject.put("jobState", job.getJobState() + "");
		jsonObject.put("jobIcon", job.getJobIcon()+"");
		return jsonObject;
	}

}
