package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Holiday;

public class JsonAppointHolidayUtil extends JsonAbstactDate {

	public Appointholiday getAppointHolidayFromJSONObject(JSONObject root_object) {
		Appointholiday appointholiday = new Appointholiday();
		appointholiday.setUserId(root_object.getInt("user_id"));
		appointholiday.setHolidayId(root_object.getInt("holidayId"));
		appointholiday.setAppointholidayName(root_object.getString("appointholidayName"));
		appointholiday.setAppointholidayPhone(root_object.getString("appointholidayPhone"));
		appointholiday.setAppointholidayNumcard(root_object.getString("appointholidayNumcard"));
		appointholiday.setAppointholidayNumpeople(Integer.parseInt(root_object.getString("appointholidayNumpeople")));
		appointholiday.setAppointholidayNotes(root_object.getString("appointholidayNotes"));
		return appointholiday;
	}

	public String getListAppointHolidayJson(List<Holiday> list) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Holiday holiday = null;
			for (int i = 0; i < list.size(); i++) {
				holiday = list.get(i);
				JSONObject jsonObject2 = getAppointHolidayToJsonObject(holiday);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
	}

	public JSONObject getAppointHolidayToJsonObject(
			Holiday holiday) {

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
