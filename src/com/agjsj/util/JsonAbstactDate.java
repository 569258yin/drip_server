package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONObject;

import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Appointtuan;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Persontuan;
import com.agjsj.entity.Resume;
import com.agjsj.entity.Talk;
import com.agjsj.entity.Talkreplay;
import com.agjsj.entity.Train;
import com.agjsj.entity.User;

public class JsonAbstactDate implements JsonDateInter {
	
	
	public JsonAbstactDate() {
	}
	/**
	 * 父类完善了其接口方法，其他继承无须重写此方法
	 * 适配器模式
	 */
	public static String createPubicJson(String requestCode, String str, int Tag) {
		JSONObject root_obj = new JSONObject();
		root_obj.put("requestCode", requestCode);
		root_obj.put("Response_info", str);
		root_obj.put("Tag", Tag);
		return root_obj.toString();
	}

	@Override
	public  String createUserJson(String requestCode, User user, int Tag) {
		return null;
	}


	@Override
	public User getUserJson(JSONObject json_class) {
		return null;
	}

	@Override
	public Resume getResumeJson(JSONObject json_class) {
		return null;
	}

	@Override
	public String createResumeJson(String requestCode, Resume resume, int Tag) {
		return null;
	}

	@Override
	public Job getJobJson(JSONObject jsonObject) {
		return null;
	}

	@Override
	public String createJobListJson(List<Job> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getJobToJsonObject(Job job) {
		return null;
	}

	@Override
	public Appointjob getAppointJobfromJSONObject(JSONObject root_object) {
		return null;
	}

	@Override
	public String getListAppointJobJson(List<Job> list) {
		return null;
	}

	@Override
	public JSONObject getAppointToJsonObject(Appointjob appointjob) {
		return null;
	}

	@Override
	public Appointholiday getAppointHolidayFromJSONObject(JSONObject root_object) {
		return null;
	}

	@Override
	public String getListAppointHolidayJson(List<Holiday> list) {
		return null;
	}

	@Override
	public JSONObject getAppointHolidayToJsonObject(
			Appointholiday appointholiday) {
		return null;
	}

	@Override
	public Holiday getHolidayJson(JSONObject jsonObject) {
		return null;
	}

	@Override
	public String createHolidayListJson(List<Holiday> list) {
		return null;
	}

	@Override
	public JSONObject getHolidayToJsonObject(Holiday holiday) {
		return null;
	}

	@Override
	public Appointtrain getAppointTrainFromJSONObject(JSONObject root_object) {
		return null;
	}

	@Override
	public String getListAppointTrainJson(List<Train> list) {
		return null;
	}

	@Override
	public JSONObject getAppointTrainToJsonObject(Train train) {
		return null;
	}

	@Override
	public Train getTrainJson(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createTrainListJson(List<Train> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getTrainToJsonObject(Train train) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Talk getTalkFromJson(JSONObject root_object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createListTalkJson(List<Talk> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getTalkToJsonObject(Talk talk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Talkreplay getTalkReplayFromJson(JSONObject root_object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persontuan getPersonTuanFromJson(JSONObject root_object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListPersonTuanToJson(List<Persontuan> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getPersontuanToJsonObject(Persontuan persontuan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointtuan getAppointTuanFromJson(JSONObject root_object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createListTalkRepalyJson(List<Talkreplay> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject createTalkRepalyJson(Talkreplay talkReplay) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createListReccomJson() {
		return null;
	}








}
