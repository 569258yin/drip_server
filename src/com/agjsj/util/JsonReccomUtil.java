package com.agjsj.util;

import java.util.List;

import com.agjsj.biz.ReccomBiz;
import com.agjsj.biz.ReccomBizImpl;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 每日推荐封装成json
 * 对数据库的操作直接在此操作
 * @author yh
 *
 */
public class JsonReccomUtil extends JsonAbstactDate{
	@Override
	public String createListReccomJson() {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		JSONObject object = new JSONObject();
		
		ReccomBiz reccoBiz = new ReccomBizImpl();
		try {
			/*
			 * job
			 */
			JsonJobUtil jobUtil = new JsonJobUtil();
			List<Job> jobList = reccoBiz.getListJob();
			if (jobList != null) {
				for (int i = 0; i < jobList.size(); i++) {
					object = jobUtil.getJobToJsonObject(jobList.get(i));
					jsonArray.add(object);
				}
			}
			jsonObject.put("job", jsonArray);
			
			/*
			 * holiday
			 */
			object.clear();
			jsonArray.clear();
			JsonHolidayUtil holidayUtil = new JsonHolidayUtil();
			List<Holiday> holidayList = reccoBiz.getListHoliday();
			if (holidayList != null) {
				for (int i = 0; i < holidayList.size(); i++) {
					object = holidayUtil.getHolidayToJsonObject(holidayList
							.get(i));
					jsonArray.add(object);
				}
			}
			jsonObject.put("holiday", jsonArray);
			/**
			 * 
			 */
			object.clear();
			jsonArray.clear();
			JsonTrainUtil trainUtil = new JsonTrainUtil();
			List<Train> trainList = reccoBiz.getListTrain();
			if (trainList != null) {
				for (int i = 0; i < holidayList.size(); i++) {
					object = trainUtil.getTrainToJsonObject(trainList.get(i));
					jsonArray.add(object);
				}
			}
			jsonObject.put("train", jsonArray);
		} catch (Exception e) {
			System.out.println("json封装我的推荐错误");
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
