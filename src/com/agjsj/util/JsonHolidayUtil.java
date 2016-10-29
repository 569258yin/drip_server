package com.agjsj.util;

import java.util.List;

import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonHolidayUtil extends JsonAbstactDate {
	
	/*
	 * 解析要收到的json字符串包装成Holiday对象（非 Javadoc）
	 * @see com.agjsj.util.JsonAbstactDate#getHolidayJson(net.sf.json.JSONObject)
	 */
	public Holiday getHolidayJson(JSONObject jsonObject){
		Holiday holiday = new Holiday();
		holiday.setUserId(jsonObject.getInt("user_id"));
		holiday.setHolidayState(0);
		holiday.setHolidayName(jsonObject.getString("holidayName"));
		holiday.setHolidayPrice(jsonObject.getString("holidayPrice"));
		
		holiday.setHolidayStartdate(jsonObject.getString("holidayStartdate"));
		holiday.setHolidayEnddate(jsonObject.getString("holidayEnddate"));
		
		holiday.setHolidayStartaddress(jsonObject.getString("holidayStartaddress"));
		holiday.setHolidayEndaddress(jsonObject.getString("holidayEndaddress"));
		
		holiday.setHolidayType(jsonObject.getString("holidayType"));
		holiday.setHolidayStartvehicle(jsonObject.getInt("holidayStartvehicle"));
		
		holiday.setHolidayEndvehicle(jsonObject.getInt("holidayEndvehicle"));
		holiday.setHolidayHotel(jsonObject.getInt("holidayHotel"));
		
		holiday.setHolidayIntro(jsonObject.getString("holidayEndvehicle"));
		holiday.setHolidayNotice(jsonObject.getString("holidayNotice"));
		
		holiday.setHolidayLookout(jsonObject.getString("holidayLookout"));
		holiday.setHolidayIcon(jsonObject.getString("holidayIcon"));
		
		holiday.setHolidayLinkman(jsonObject.getString("holidayLinkman"));
		holiday.setHolidayPhone(jsonObject.getString("holidayPhone"));
		
		
		return holiday;
	}
	

	public String createHolidayListJson(List<Holiday> list){
		return createHolidayJSONListJson(list).toString();
	}
	
	public JSONObject createHolidayJSONListJson(List<Holiday> list){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject;

		} else {
			jsonObject.put("Tag", "1");
			Holiday holiday= null;
			for (int i = 0; i < list.size(); i++) {
				holiday = list.get(i);
				JSONObject jsonObject2 = getHolidayToJsonObject(holiday);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject;
		}
	}
	/*
	 * 封装要返回的Holiday对象成JSON字符串（非 Javadoc）
	 * @see com.agjsj.util.JsonAbstactDate#getHolidayToJsonObject(com.agjsj.entity.Holiday)
	 */
	public JSONObject getHolidayToJsonObject(Holiday holiday){

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("holidayId", holiday.getHolidayId() + "");
		jsonObject.put("user_id", holiday.getUserId() + "");
		
		jsonObject.put("holidayState", holiday.getHolidayState() + "");
		jsonObject.put("holidayName", holiday.getHolidayName() + "");
		
		jsonObject.put("holidayPrice", holiday.getHolidayPrice() + "");
		jsonObject.put("holidayStartdate", holiday.getHolidayStartdate() + "");
		
		jsonObject.put("holidayEnddate", holiday.getHolidayEnddate() + "");
		jsonObject.put("holidayStartaddress", holiday.getHolidayStartaddress() + "");
		
		jsonObject.put("holidayEndaddress", holiday.getHolidayEndaddress() + "");
		jsonObject.put("holidayType", holiday.getHolidayType() + "");
		
		jsonObject.put("holidayStartvehicle", holiday.getHolidayStartvehicle() + "");
		jsonObject.put("holidayEndvehicle", holiday.getHolidayEndvehicle() + "");
		
		jsonObject.put("holidayHotel", holiday.getHolidayHotel() + "");
		jsonObject.put("holidayIntro", holiday.getHolidayIntro() + "");
		
		jsonObject.put("holidayNotice", holiday.getHolidayNotice() + "");
		jsonObject.put("holidayLookout", holiday.getHolidayLookout()+ "");
		
		jsonObject.put("holidayIcon", holiday.getHolidayIcon() + "");
		jsonObject.put("holidayLinkman", holiday.getHolidayLinkman()+ "");
		
		jsonObject.put("holidayPhone", holiday.getHolidayPhone()+ "");
		

		return jsonObject;
	}
}
