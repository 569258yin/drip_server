package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.biz.UserBiz;
import com.agjsj.biz.UserBizImpl;
import com.agjsj.entity.Holidayreplay;
import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Optuanreplay;
import com.agjsj.entity.Talkreplay;
import com.agjsj.entity.Trainreplay;

public class JsonReplayUtil {

//------------------------------------------------------------------------------------------
	/**
	 * 得到旅游度假的评论信息
	 * @param list
	 * @return
	 */
	public static String createListHolidayRepalyJson(List<Holidayreplay> list) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Holidayreplay holidayRepaly = null;
			for (int i = 0; i < list.size(); i++) {
				holidayRepaly = list.get(i);
				JSONObject jsonObject2 = createHolidayRepalyJson(holidayRepaly);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
		
	}
	
	/**
	 *封装旅游度假评论的json数据对象
	 * @param holidayReplay
	 * @return
	 */
	public static JSONObject createHolidayRepalyJson(Holidayreplay holidayReplay) {
		JSONObject jsonObject = new JSONObject();
		UserBiz user = new UserBizImpl();
		String[] str = user.getUserNameAndIcon(holidayReplay.getUserId());
		jsonObject.put("userName", str[0]+"");
		jsonObject.put("userIcon",str[1]+"");
 		jsonObject.put("user_id", holidayReplay.getUserId());
		jsonObject.put("holidayId", holidayReplay.getHolidayId());
		jsonObject.put("holidayreplayId", holidayReplay.getHolidayreplayId());
		jsonObject.put("holidayreplayContext", holidayReplay.getHolidayreplayContext());
		jsonObject.put("holidayreplayTime", holidayReplay.getHolidayreplayTime());
		return jsonObject;
	}
	
	/**
	 * 从json字符串中获取旅游度假对象
	 * @param root_object
	 * @return
	 */
	public static Holidayreplay getHolidaReplayFromJson(JSONObject root_object) {
		Holidayreplay holidayreplay = new Holidayreplay();
		holidayreplay.setHolidayId(root_object.getInt("holidayId"));
		holidayreplay.setUserId(root_object.getInt("user_id"));
		holidayreplay.setHolidayreplayContext(root_object
				.getString("holidayreplayContext"));
		holidayreplay.setHolidayreplayTime(DateUtil.getCurrentDate());
		return holidayreplay;
	}
	
	
//---------------------------------------------------------------------------------------------、
	/**
	 * 得到兼职招聘的评论信息
	 * @param list
	 * @return
	 */
	public static String createListJobRepalyJson(List<Jobreplay> list) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Jobreplay jobRepaly = null;
			for (int i = 0; i < list.size(); i++) {
				jobRepaly = list.get(i);
				JSONObject jsonObject2 = createJobRepalyJson(jobRepaly);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
		
	}
	
	/**
	 *封装兼职招聘评论的json数据对象
	 * @param holidayReplay
	 * @return
	 */
	public static JSONObject createJobRepalyJson(Jobreplay jobReplay) {
		JSONObject jsonObject = new JSONObject();
		UserBiz user = new UserBizImpl();
		String[] str = user.getUserNameAndIcon(jobReplay.getUserId());
		jsonObject.put("userName", str[0]+"");
		jsonObject.put("userIcon",str[1]+"");
 		jsonObject.put("user_id", jobReplay.getUserId());
		jsonObject.put("jobId", jobReplay.getJobId());
		jsonObject.put("jobreplayId", jobReplay.getJobreplayId());
		jsonObject.put("jobreplayContext", jobReplay.getJobreplayContext());
		jsonObject.put("jobreplayTime", jobReplay.getJobreplayTime());
		return jsonObject;
	}
	
	/**
	 * 从json字符串中获取兼职招聘的对象
	 * @param root_object
	 * @return
	 */
	public static Jobreplay getJobReplayFromJson(JSONObject root_object) {
		Jobreplay jobreplay = new Jobreplay();
		jobreplay.setJobId(root_object.getInt("jobId"));
		jobreplay.setUserId(root_object.getInt("user_id"));
		jobreplay.setJobreplayContext(root_object
				.getString("jobreplayContext"));
		jobreplay.setJobreplayTime(DateUtil.getCurrentDate());
		return jobreplay;
	}
	
	
//----------------------------------------------------------------------------------------------
	/**
	 * 得到教育培训的评论信息
	 * @param list
	 * @return
	 */
	public static String createListTrainRepalyJson(List<Trainreplay> list) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Trainreplay trainRepaly = null;
			for (int i = 0; i < list.size(); i++) {
				trainRepaly = list.get(i);
				JSONObject jsonObject2 = createTrainRepalyJson(trainRepaly);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
		
	}
	
	/**
	 *封装教育培训评论的json数据对象
	 * @param holidayReplay
	 * @return
	 */
	public static JSONObject createTrainRepalyJson(Trainreplay trainReplay) {
		JSONObject jsonObject = new JSONObject();
		UserBiz user = new UserBizImpl();
		String[] str = user.getUserNameAndIcon(trainReplay.getUserId());
		jsonObject.put("userName", str[0]+"");
		jsonObject.put("userIcon",str[1]+"");
 		jsonObject.put("user_id", trainReplay.getUserId());
		jsonObject.put("trainId", trainReplay.getTrainId());
		jsonObject.put("trainreplayId", trainReplay.getTrainreplayId());
		jsonObject.put("trainreplayContext", trainReplay.getTrainreplayContext());
		jsonObject.put("trainreplayTime", trainReplay.getTrainreplayTime());
		return jsonObject;
	}
	
	/**
	 * 从json字符串中获取教育培训的对象
	 * @param root_object
	 * @return
	 */
	public static Trainreplay getTrainReplayFromJson(JSONObject root_object) {
		Trainreplay trainreplay = new Trainreplay();
		trainreplay.setTrainId(root_object.getInt("trainId"));
		trainreplay.setUserId(root_object.getInt("user_id"));
		trainreplay.setTrainreplayContext(root_object
				.getString("trainreplayContext"));
		trainreplay.setTrainreplayTime(DateUtil.getCurrentDate());
		return trainreplay;
	}
	
	//----------------------------------------------------------------------------------------------
		/**
		 * 得到教育培训的评论信息
		 * @param list
		 * @return
		 */
		public static String createListOptuanRepalyJson(List<Optuanreplay> list) {
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			if (list == null) {

				jsonObject.put("Tag", "0");
				jsonObject.put("list", jsonArray);
				return jsonObject.toString();

			} else {
				jsonObject.put("Tag", "1");
				Optuanreplay optuanreplay = null;
				for (int i = 0; i < list.size(); i++) {
					optuanreplay = list.get(i);
					JSONObject jsonObject2 = createOptuanRepalyJson(optuanreplay);
					jsonArray.add(jsonObject2);
				}
				jsonObject.put("list", jsonArray);
				return jsonObject.toString();
			}
			
		}
		
		/**
		 *封装教育培训评论的json数据对象
		 * @param holidayReplay
		 * @return
		 */
		public static JSONObject createOptuanRepalyJson(Optuanreplay optuanreplay) {
			JSONObject jsonObject = new JSONObject();
			UserBiz user = new UserBizImpl();
			String[] str = user.getUserNameAndIcon(optuanreplay.getUserId());
			jsonObject.put("userName", str[0]+"");
			jsonObject.put("userIcon",str[1]+"");
	 		jsonObject.put("user_id", optuanreplay.getUserId());
			jsonObject.put("opentuanId", optuanreplay.getOpentuanId());
			jsonObject.put("optuanreplayId", optuanreplay.getOptuanreplayId());
			jsonObject.put("optuanreplayContext", optuanreplay.getOptuanreplayContext());
			jsonObject.put("optuanreplayTime", optuanreplay.getOptuanreplayTime());
			return jsonObject;
		}
		
		/**
		 * 从json字符串中获取教育培训的对象
		 * @param root_object
		 * @return
		 */
		public static Optuanreplay getOptuanReplayFromJson(JSONObject root_object) {
			Optuanreplay optuanreplay = new Optuanreplay();
			optuanreplay.setOpentuanId(root_object.getInt("opentuanId"));
			optuanreplay.setUserId(root_object.getInt("user_id"));
			optuanreplay.setOptuanreplayContext(root_object
					.getString("optuanreplayContext"));
			optuanreplay.setOptuanreplayTime(DateUtil.getCurrentAllDate());
			return optuanreplay;
		}
}
