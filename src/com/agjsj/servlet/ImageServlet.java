package com.agjsj.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;














import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.agjsj.util.DateUtil;
import com.agjsj.util.HttpImageUtil;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonDateInter;

public class ImageServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("start");
//		System.out.println(request.getContextPath());
		int tag = 0;
		String json_date = "";
		try {
			tag = HttpImageUtil.upload(request);
		} catch (FileSizeLimitExceededException e) {
			tag = 0;
			System.out.println("文件太大");
			e.printStackTrace();
		}
		if (tag == 0) {
			json_date = JsonAbstactDate.createPubicJson("0000", "上传失败", tag);
		}else if(tag == 1){
			json_date = JsonAbstactDate.createPubicJson("0000", "上传成功", tag);
		}else if(tag == -1){
			json_date = JsonAbstactDate.createPubicJson("0000", "文件格式不对", tag);
		}
		System.out.println(tag);
		HttpUtil.sendDateStream(json_date, response);
		System.out.println("end");


	}

	
	


	//	try {
	//	DefaultFileItemFactory factory = new DefaultFileItemFactory();
	//	DiskFileUpload up = new DiskFileUpload(factory);
	//	List<FileItem> ls = up.parseRequest(request);
	//	for (FileItem fileItem : ls) {
	//		if (fileItem.isFormField()) {
	//			String FieldName = fileItem.getFieldName();
	//			// getName()返回的是文件名字 普通域没有文件 返回NULL
	//			// String Name = fileItem.getName();
	//			String Content = fileItem.getString("utf-8");
	//			request.setAttribute(FieldName, Content);
	//		} else {
	//
	//			String nm = fileItem.getName().substring(
	//					fileItem.getName().lastIndexOf("\\") + 1);
	//			File mkr = new File(path, nm);
	//			if (mkr.createNewFile()) {
	//				path = path + File.separator + nm;
	//				fileItem.write(mkr);// 非常方便的方法
	//			}
	//		}
	//	}
	//} catch (Exception e) {
	//	e.printStackTrace();
	//}

	public void init() throws ServletException {
	}

}
