package com.agjsj.util;

import net.sf.json.JSONObject;

import com.agjsj.entity.Appointtuan;

public class JsonAppointTuanUtil extends JsonAbstactDate {

	public Appointtuan getAppointTuanFromJson(JSONObject root_object) {

		Appointtuan appointtuan = new Appointtuan();  

//		appointtuan.setAppointtuanId(Integer.parseInt(root_object.getString("appointtuanId")));
		appointtuan.setPersontuanId(Integer.parseInt(root_object.getString("persontuanId")));
		appointtuan.setUserId(Integer.parseInt(root_object.getString("user_id")));
		appointtuan
				.setAppointtuanName("");
		appointtuan.setAppointtuanPhone("");
		appointtuan.setAppointtuanNumcard("");
		appointtuan.setAppointtuanNumpeople(0);
		appointtuan.setAppointtuanNotes("");

		return appointtuan;
	}
}
