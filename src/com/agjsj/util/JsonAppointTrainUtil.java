package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Train;

public class JsonAppointTrainUtil extends JsonAbstactDate{
	
	@Override
	public Appointtrain getAppointTrainFromJSONObject(JSONObject root_object) {
		Appointtrain appointtrain = new Appointtrain();
		appointtrain.setUserId(Integer.parseInt(root_object.getString("user_id")));
		appointtrain.setTrainId(Integer.parseInt(root_object.getString("trainId")));
		appointtrain.setAppointtrainName(root_object.getString("appointtrainName"));
		appointtrain.setAppointtrainPhone(root_object.getString("appointtrainPhone"));
		appointtrain.setAppointtrainNumcard(root_object.getString("appointtrainNumcard"));
		appointtrain.setAppointtrainNumpeople(root_object.getInt("appointtrainNumpeople"));
		appointtrain.setAppointtrainNotes(root_object.getString("appointtrainNotes"));
		return appointtrain;
	}
	
	
	@Override
	public String getListAppointTrainJson(List<Train> list) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Train train = null;
			for (int i = 0; i < list.size(); i++) {
				train = list.get(i);
				JSONObject jsonObject2 = getAppointTrainToJsonObject(train);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
	}
	
	
	
	@Override
	public JSONObject getAppointTrainToJsonObject(Train train) {
		JSONObject object = new JSONObject();
		object.put("trainId", train.getTrainId());
		object.put("user_id", train.getUserId());
		object.put("courseName", train.getCourseName());
		object.put("trainPrice", train.getTrainPrice());
		object.put("trainStartdate", train.getTrainStartdate());
		object.put("trainEnddate", train.getTrainEnddate());
		object.put("trainCity", train.getTrainCity());
		object.put("trainAddress", train.getTrainAddress());
		object.put("trainTime", train.getTrainTime());
		object.put("trainType", train.getTrainType());
		object.put("trainIcon", train.getTrainIcon());
		object.put("trainNotice", train.getTrainNotice());
		object.put("trainDescription", train.getTrainDescription());
		object.put("trainLinkman", train.getTrainLinkman());
		object.put("trainPhone", train.getTrainPhone());
		
		return object;
	}
}
