package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Job;

public class JsonAppointJobUtil extends JsonAbstactDate {

	public Appointjob getAppointJobfromJSONObject(JSONObject root_object) {
		Appointjob appointjob = new Appointjob();

		appointjob.setUserId(root_object.getInt("user_id"));
		appointjob.setJobId(root_object.getInt("jobId"));
		appointjob.setAppointjobName(root_object.getString("appointjobName"));
		appointjob.setAppointjobNotes(root_object.getString("appointjobNotes"));
		appointjob.setAppointjobNumcard(root_object
				.getString("appointjobNumcard"));
		appointjob.setAppointjobNumpeople(root_object
				.getString("appointjobNumpeople"));
		appointjob.setAppointjobPhone(root_object.getString("appointjobPhone"));

		return appointjob;
	}

	public String getListAppointJobJson(List<Job> list) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Job job = null;
			for (int i = 0; i < list.size(); i++) {
				job = list.get(i);
				JSONObject jsonObject2 = getAppointToJsonObject(job);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}

	}

	public JSONObject getAppointToJsonObject(Job job) {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("jobId", job.getJobId()+"");
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
	return jsonObject;
	}
}
