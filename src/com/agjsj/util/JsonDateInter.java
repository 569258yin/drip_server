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

public interface JsonDateInter {
	
	
	/**
	 * 创建json带有user返回字符串
	 * @param requestCode	
	 * @param user
	 * @param Tag
	 * @return
	 */
	public String createUserJson(String requestCode,User user,int Tag);

	/**
	 * 从json字符串中得到user对象
	 * @param json_class
	 * @return
	 */
	public User getUserJson(JSONObject json_class);
//-------------------------------------------------------------------------------------	
	/**
	 * 从json字符串中得到Resume简历对象
	 * @param json_class
	 * @return
	 */
	public Resume getResumeJson(JSONObject json_class);
	
	/**
	 * 创建json带有Resume返回字符串
	 * @param requestCode
	 * @param resume
	 * @param Tag
	 * @return
	 */
	public String createResumeJson(String requestCode,Resume resume,int Tag);
	
//------------------------------------------------------------------------
	/**
	 * 解析json生成要发布兼职的job对象
	 * 
	 * @param jsonObject
	 *            客户端发过来的json字符串，该字符串包含要发布的兼职信息
	 * @return job对象
	 */
	public Job getJobJson(JSONObject jsonObject);
	
	/**
	 * 将数据库查询出来的list<job>集合封装成json字符串
	 * 
	 * @param list
	 *            list<job>集合
	 * @return
	 */
	public String createJobListJson(List<Job> list);

	/**
	 * 将job对象封装成JSONObject对象，用于辅助其他方法
	 * 
	 * @param job
	 *            job对象
	 * @return
	 */
	public JSONObject getJobToJsonObject(Job job);
//-----------------------------------------------------------------------------------------------
	/**
	 * 从客户端发来的jsonObject中获取AppointJob对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Appointjob getAppointJobfromJSONObject(JSONObject root_object);

	/**
	 * 将从数据库中查询出来的AppointJob的list，转化成json字符串
	 * 
	 * @param list
	 * @return
	 */
	public String getListAppointJobJson(List<Job> list);

	/**
	 * 将AppointJob对象转化成JSONOBject对象
	 * 
	 * @param appointjob
	 * @return
	 */
	public JSONObject getAppointToJsonObject(Appointjob appointjob);
	
//-------------------------------------------------------------------------------------------
	/**
	 * 从客户端发来的jsonObject中，获取AppointHoliday对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Appointholiday getAppointHolidayFromJSONObject(JSONObject root_object);

	/**
	 * 将从客户端获取的List<appointholiday>封装成json字符串。
	 * 
	 * @param list
	 * @return
	 */
	public String getListAppointHolidayJson(List<Holiday> list);

	/**
	 * 将Appointholiday对象转化成JsonObject对象
	 * 
	 * @param appointholiday
	 * @return
	 */
	public JSONObject getAppointHolidayToJsonObject(
			Appointholiday appointholiday);
	
//----------------------------------------------------------------------------------------------
	/*
	 * 解析json生成要发布度假的holiday对象
	 */
	public Holiday getHolidayJson(JSONObject jsonObject);
	
	/*
	 *  将数据库查询出来的list<Holiday>集合封装成json字符串
	 */
	public String createHolidayListJson(List<Holiday> list);
	
	/*
	 * 将holiday对象封装成JSONObject对象，用于辅助其他方法
	 */
	public JSONObject getHolidayToJsonObject(Holiday holiday);
	
//------------------------------------------------------------------------------------------------
	/**
	 * 从客户端发来的jsonObject中，获取AppointHoliday对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Appointtrain getAppointTrainFromJSONObject(JSONObject root_object);

	/**
	 * 将从数据库获取的List<Train>封装成json字符串。
	 * 
	 * @param list
	 * @return
	 */
	public String getListAppointTrainJson(List<Train> list);

	/**
	 * 将Train对象转化成JsonObject对象
	 * 
	 * @param appointholiday
	 * @return
	 */
	public JSONObject getAppointTrainToJsonObject(
			Train train);
//------------------------------------------------------------------------------------------
	/*
	 * 解析json生成要发布培训的Train对象
	 */
	public Train getTrainJson(JSONObject jsonObject);
	
	/*
	 *  将数据库查询出来的list<Train>集合封装成json字符串
	 */
	public String createTrainListJson(List<Train> list);
	
	/*
	 * 将Train对象封装成JSONObject对象，用于辅助其他方法
	 */
	public JSONObject getTrainToJsonObject(Train train);
//-------------------------------------------------------------------------------------------
	/**
	 * 从json字符串中提取出Talk对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Talk getTalkFromJson(JSONObject root_object);

	/**
	 * 将List<talk>集合转化成json字符串
	 * 
	 * @param list
	 * @return
	 */
	public String createListTalkJson(List<Talk> list);

	/**
	 * 将Talk对象转化成JsonObject对象
	 * 
	 * @param talk
	 * @return
	 */
	public JSONObject getTalkToJsonObject(Talk talk);

	/**
	 * 从JsonObject对象中提取出TalkReplay对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Talkreplay getTalkReplayFromJson(JSONObject root_object);
	
//---------------------------------------------------------------------------------

	/**
	 * 从JsonObject中提取出PersonTuan对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Persontuan getPersonTuanFromJson(JSONObject root_object);

	/**
	 * 将list<Persontuan>封装成json字符串
	 * 
	 * @param list
	 * @return
	 */
	public String getListPersonTuanToJson(List<Persontuan> list);

	/**
	 * 将Persontuan对象转化成jsonObject对象
	 * 
	 * @param persontuan
	 * @return
	 */
	public JSONObject getPersontuanToJsonObject(Persontuan persontuan);

	// ---------------------------------------------------------
	/**
	 * 从jsonobject中获取AppointTuan对象
	 * 
	 * @param root_object
	 * @return
	 */
	public Appointtuan getAppointTuanFromJson(JSONObject root_object);
//---------------------------------------------------------------------------------------
	public String createListTalkRepalyJson(List<Talkreplay> list);
	
	public JSONObject createTalkRepalyJson(Talkreplay talkReplay);
//-------------------------------------------------------------------------------------
	/**
	 * 获取每日推荐的；list json字符串
	 * @param list
	 * @return
	 */
	public String createListReccomJson();
}
