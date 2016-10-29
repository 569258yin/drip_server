package com.agjsj.util;

import java.util.HashMap;

import net.sf.json.JSONObject;

import com.agjsj.entity.User;

public class JsonUserUtil extends JsonAbstactDate {
	
	
	@Override
	public String createUserJson(String requestCode, User user, int Tag) {
		JSONObject root_obj = new JSONObject();
		//状态值
		root_obj.put("requestCode", requestCode);
		//user 
		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("UUID", user.getUUID());
		map.put("requestCode", requestCode);
		map.put("userId", user.getUserId()+"");
		map.put("userName", user.getUserName()+"");
		map.put("userPsw", user.getUserPsw()+"");
		map.put("userSex", user.getUserSex()+"");
		map.put("userPhone", user.getUserPhone()+"");
		map.put("userEmail", user.getUserEmail()+"");
		map.put("userAddress", user.getUserAddress()+"");
		map.put("userAddressinfo", user.getUserAddressinfo()+"");
		map.put("userIcon", user.getUserIcon()+"");
		map.put("userBirthdate", user.getUserBirthdate()+"");
		map.put("Tag",Tag+"");
		root_obj.putAll(map);
		//图片
		return root_obj.toString();
	}
	
	@Override
	public User getUserJson(JSONObject json_class) {
		User user = new User();
		user.setUserName( json_class.getString("userName"));
		user.setUserPsw(json_class.getString("userPsw"));
		user.setUserSex(Integer.parseInt(json_class.getString("userSex")));
		user.setUserPhone(json_class.getString("userPhone"));
		user.setUserEmail(json_class.getString("userEmail"));
		user.setUserAddress(json_class.getString("userAddress"));
		user.setUserAddressinfo(json_class.getString("userAddressinfo"));
		user.setUserBirthdate(json_class.getString("userBirthdate"));
		
		System.out.println(user.toString());
		return user;
	}
	
	
}
