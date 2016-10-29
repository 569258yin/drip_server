package com.agjsj.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 得到现有的事件 yyyy-MM-dd
	 * @return
	 */
	public static String getCurrentDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * 得到现有的事件   yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentAllDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
//		return date.toString();
	}
}	
