package com.agjsj.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.entity.Message;

public class JsonMessageUtil {
	
	public static String getListToJson(List<Message> list){
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", array);
			return jsonObject.toString();

		} 
		else{
			jsonObject.put("Tag", "1");
			for (int i = 0; i < list.size(); i++) {
				array.add(getMessageJson((list.get(i))));
			}
			jsonObject.put("list", array);
		}
		return jsonObject.toString();
		
	}
	
	public static JSONObject getMessageJson(Message message){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userSendId", message.getUserSendId());
		jsonObject.put("userReceiveId", message.getUserReceiveId());
		jsonObject.put("messageContext", message.getMessageContext());
		jsonObject.put("messageTime", message.getMessageTime());
		jsonObject.put("messageTag", message.getMessageTag());
		return jsonObject;
		
	}
}
