package com.agjsj.util;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Train;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTrainUtil extends JsonAbstactDate{
	/*
	 * 解析要收到的json字符串包装成Train对象（非 Javadoc）
	 * @see com.agjsj.util.JsonAbstactDate#getHolidayJson(net.sf.json.JSONObject)
	 */
	public Train getTrainJson(JSONObject jsonObject){
		Train train = new Train();
		train.setUserId(jsonObject.getInt("user_id"));
		train.setCourseName(jsonObject.getString("courseName"));
		train.setTrainState(0);
		train.setTrainPrice(jsonObject.getString("trainPrice"));
		train.setTrainStartdate(jsonObject.getString("trainStartdate"));

		train.setTrainEnddate(jsonObject.getString("trainEnddate"));
		train.setTrainCity(jsonObject.getString("trainCity"));

		train.setTrainAddress(jsonObject.getString("trainAddress"));
		train.setTrainTime(jsonObject.getString("trainTime"));

		train.setTrainType(jsonObject.getString("trainType"));
		train.setTrainIcon(jsonObject.getString("trainIcon"));

		train.setTrainNotice(jsonObject.getString("trainNotice"));
		train.setTrainDescription(jsonObject.getString("trainDescription"));

		train.setTrainLinkman(jsonObject.getString("trainLinkman"));
		train.setTrainPhone(jsonObject.getString("trainPhone"));


		return train;
	}
	/*
	 * 把集合中的对象循环取出解析成jsonObject，再把jsonObject放到JsonArray中，再把jsonArray put到jsonObject（非 Javadoc）
	 * @see com.agjsj.util.JsonAbstactDate#createHolidayListJson(java.util.List)
	 */

	public String createTrainListJson(List<Train> list){
		return createTrainJSONListJson(list).toString();
	}

	public JSONObject createTrainJSONListJson(List<Train> list){

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject;

		} else {
			jsonObject.put("Tag", "1");
			Train train= null;
			for (int i = 0; i < list.size(); i++) {
				train = list.get(i);
				JSONObject jsonObject2 = getTrainToJsonObject(train);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject;
		}

	}
	/*
	 * 封装要返回的Train对象成JSON字符串（非 Javadoc）
	 * @see com.agjsj.util.JsonAbstactDate#getHolidayToJsonObject(com.agjsj.entity.Holiday)
	 */
	public JSONObject getTrainToJsonObject(Train train){

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("trainId", train.getTrainId() + "");
		jsonObject.put("user_id", train.getUserId() + "");

		jsonObject.put("courseName", train.getCourseName() + "");
		jsonObject.put("trainPrice", train.getTrainPrice() + "");

		jsonObject.put("trainStartdate", train.getTrainStartdate() + "");
		jsonObject.put("trainEnddate", train.getTrainEnddate() + "");

		jsonObject.put("trainCity", train.getTrainCity() + "");
		jsonObject.put("trainAddress", train.getTrainAddress() + "");

		jsonObject.put("trainTime", train.getTrainTime() + "");
		jsonObject.put("trainType", train.getTrainType() + "");

		jsonObject.put("trainIcon", train.getTrainIcon() + "");
		jsonObject.put("trainNotice", train.getTrainNotice() + "");

		jsonObject.put("trainDescription", train.getTrainDescription() + "");
		jsonObject.put("trainLinkman", train.getTrainLinkman() + "");
		jsonObject.put("trainState", train.getTrainState()+"");
		jsonObject.put("trainPhone", train.getTrainPhone() + "");

		return jsonObject;

	}
}
