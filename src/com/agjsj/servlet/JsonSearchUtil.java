package com.agjsj.servlet;

import java.util.List;

import net.sf.json.JSONObject;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;
import com.agjsj.util.JsonHolidayUtil;
import com.agjsj.util.JsonJobUtil;
import com.agjsj.util.JsonTrainUtil;

public class JsonSearchUtil {
	public static String getListAllSearch(List<Job> jobList,List<Holiday> holidayList
			,List<Train> trainList){
		JSONObject jsonObject = new JSONObject();
		JsonJobUtil jobUtil = new JsonJobUtil();
		jsonObject.put("job", jobUtil.createJobJSONListJson(jobList));
		JsonHolidayUtil holidayUtil = new JsonHolidayUtil();
		jsonObject.put("holiday", holidayUtil.createHolidayJSONListJson(holidayList));
		JsonTrainUtil trainUtil = new JsonTrainUtil();
		jsonObject.put("train", trainUtil.createTrainJSONListJson(trainList));
		return jsonObject.toString();
	}
}
