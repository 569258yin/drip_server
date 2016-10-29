package com.agjsj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.entity.Persontuan;

public class JsonPersonTuanUtil extends JsonAbstactDate {

	public Persontuan getPersonTuanFromJson(JSONObject root_object) {

		Persontuan persontuan = new Persontuan();

		persontuan.setPersontuanId(null);
		persontuan.setUserId(Integer.parseInt(root_object.getString("user_id")));
		persontuan.setPersontuanRealname(root_object
				.getString("persontuanRealname"));
		persontuan.setPersontuanTitle(root_object.getString("persontuanTitle"));
		persontuan.setPersontuanQq(root_object.getString("persontuanQq"));
		persontuan.setPersontuanStartplace(root_object
				.getString("persontuanStartplace"));
		persontuan.setPersontuanEndplace(root_object
				.getString("persontuanEndplace"));
		persontuan.setPersontuanStartdate(root_object
				.getString("persontuanStartdate"));
		persontuan.setPersontuanDays(root_object.getString("persontuanDays"));
		persontuan.setPersontuanPeople(root_object
				.getString("persontuanPeople"));
		persontuan.setPersontuanMoney(root_object.getString("persontuanMoney"));
		persontuan.setPersontuanTraveltype(root_object
				.getString("persontuanTraveltype"));
		persontuan.setPersontuanHotelreq(root_object
				.getString("persontuanHotelreq"));
		persontuan.setPersontuanHotelplace(root_object
				.getString("persontuanHotelplace"));
		persontuan.setPersontuanHoteltype(root_object
				.getString("persontuanHoteltype"));
		persontuan.setPersontuanLinktime(root_object
				.getString("persontuanLinktime"));
		persontuan.setPersontuanIsguide(root_object
				.getString("persontuanIsguide"));
		persontuan.setPersontuanOtherreq(root_object
				.getString("persontuanOtherreq"));
		persontuan.setPersontuanPhone(root_object.getString("persontuanPhone"));
		//获取当前时间
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
		persontuan.setPersontuanTime(DateUtil.getCurrentAllDate()+"");
		persontuan.setPersontuanUsericon(root_object.getString("PersontuanUsericon"));
		return persontuan;
	}

	public String getListPersonTuanToJson(List<Persontuan> list) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Persontuan persontuan = null;
			for (int i = 0; i < list.size(); i++) {
				persontuan = list.get(i);
				JSONObject jsonObject2 = getPersontuanToJsonObjec(persontuan);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
	}

	public static JSONObject getPersontuanToJsonObjec(Persontuan persontuan) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("persontuanId", persontuan.getPersontuanId());

		jsonObject.put("user_id", persontuan.getUserId());
		jsonObject.put("persontuanRealname", persontuan.getPersontuanRealname());
		jsonObject.put("persontuanTitle", persontuan.getPersontuanTitle());
		jsonObject.put("persontuanQq", persontuan.getPersontuanQq());
		jsonObject.put("persontuanStartplace", persontuan.getPersontuanStartplace());
		jsonObject.put("persontuanEndplace", persontuan.getPersontuanEndplace());
		jsonObject.put("persontuanStartdate", persontuan.getPersontuanStartdate());
		jsonObject.put("persontuanDays", persontuan.getPersontuanDays());
		jsonObject.put("persontuanPeople", persontuan.getPersontuanPeople());
		jsonObject.put("persontuanMoney", persontuan.getPersontuanMoney());
		jsonObject.put("persontuanTraveltype", persontuan.getPersontuanTraveltype());
		jsonObject.put("persontuanHotelreq", persontuan.getPersontuanHotelreq());
		jsonObject.put("persontuanHotelplace", persontuan.getPersontuanHotelplace());
		jsonObject.put("persontuanHoteltype", persontuan.getPersontuanHoteltype());
		jsonObject.put("persontuanLinktime", persontuan.getPersontuanLinktime());
		jsonObject.put("persontuanIsguide", persontuan.getPersontuanIsguide());
		jsonObject.put("persontuanOtherreq", persontuan.getPersontuanOtherreq()+"");
		jsonObject.put("persontuanPhone", persontuan.getPersontuanPhone()+"");
		jsonObject.put("PersontuanUsericon", persontuan.getPersontuanUsericon());
		jsonObject.put("PersontuanTime", persontuan.getPersontuanTime());
		return jsonObject;
	}

}
