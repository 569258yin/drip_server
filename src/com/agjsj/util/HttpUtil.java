package com.agjsj.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	
	private final static String ENCODING = "UTF-8";
	
	public static void sendDateStream(String json_date,HttpServletResponse response) {
		System.out.println(json_date);
		BufferedWriter bw = null;
		try {
			
			bw = new BufferedWriter(
					new OutputStreamWriter(response.getOutputStream(),ENCODING));
			bw.write(json_date);
			bw.flush();
		} catch (IOException e) {
			System.out.println("发送数据失败");
			e.printStackTrace();
		}finally{
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	
	
	public static String getDateStream(HttpServletRequest request) {
		String json_str="";
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							request.getInputStream(), ENCODING));
			json_str = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(json_str);
		return json_str;

	}
	
	public static String getRootDateStream(HttpServletRequest request) {
		String json_str="";
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							request.getInputStream(), ENCODING));
			json_str = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json_str);
		return json_str;

	}
}
