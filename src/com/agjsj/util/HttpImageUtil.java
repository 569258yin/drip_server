package com.agjsj.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.agjsj.biz.ImageBiz;
import com.agjsj.biz.ImageBizImpl;
import com.agjsj.servlet.Application;

public class HttpImageUtil {
	private final static String ENCODING = "utf-8";
	/**
	 * 文件上传
	 * @param request
	 */
	public static synchronized int upload(HttpServletRequest request) throws FileSizeLimitExceededException {
		int tag = 0;
		String requestCode="";
		String url = "";
		String id = "";
		String user_id = "";
		String path = request.getSession().getServletContext().getRealPath(File.separator+"image");
		//上传时生成的临时文件保存目录
		String tempPath = request.getSession().getServletContext().getRealPath(File.separator+"temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			//创建临时目录
			tmpFile.mkdir();
		}
		try {
			//创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置缓冲区的大小
			factory.setSizeThreshold(1024*100);
			//设置上传文件临时文件的保存路径
			factory.setRepository(tmpFile);
			//创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setProgressListener(new ProgressListener() {

				@Override
				public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
				}
			});

			//设置编码格式 
			upload.setHeaderEncoding(ENCODING);
			//判断是否是表单提交
			if(!ServletFileUpload.isMultipartContent(request)){
				//按照传统方式获取数据
				return tag;
			}
			//设置图片最大限制
			upload.setFileSizeMax(1024*1024);
			//使用解析器对上传的文件进行解析
			List<FileItem> list = upload.parseRequest(request);
			System.out.println(list.toString());
			for (FileItem fileItem : list) {
				//如果封装的是普通的数据
				if (fileItem.isFormField()) {
					String requestName = fileItem.getFieldName();
					//解决普通输入项的中文乱码问题
					String requestValue = fileItem.getString(ENCODING);
					System.out.println(requestName+"="+requestCode);
					if (requestName.equals("requestCode")) {
						requestCode = requestValue;
					}else if(requestName.equals("id")){
						id = requestValue;
					}else if(requestName.equals("user_id")){
						user_id = requestValue;
					}
					
				}else{	//封装的是上传的文件
					//得到上传的文件名
					String fileName = fileItem.getName();
					System.out.println(fileName);
					if (fileName == null || fileName.trim().equals("")) {
						continue;
					}
					//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
					//如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					//处理获取到的上传文件的文件名的路径部分，只保留文件名
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					//得到上传文件的扩展名
					String fileExtName = fileName.substring(fileName.lastIndexOf(".")+1);
					System.out.println("上传的文件的扩展名是："+fileExtName);

					//获取item上传的输入流
					InputStream is = fileItem.getInputStream();
					//获取唯一名
					String saveFileName= makeFileName(fileName);
					if (requestCode.equals("user")) {
						saveFileName = user_id+"."+"png";
						System.out.println("user名字唯一了！"+saveFileName);
					}
//					String realFilePath = makePath(saveFileName, path);
					String realFilePath = path+File.separator+user_id;
//					String otherPath =  request.getContextPath();
//					String otherFilePath = makePath(saveFileName, otherPath+"/image");
					/**
					 * 创建文件夹
					 */
					String otherFilePath = request.getContextPath()+File.separator+"image"+File.separator+user_id;
					File filePath = new File(realFilePath);
					if (!filePath.exists()) {
						filePath.mkdirs();
					}
					/**
					 * 创建文件
					 */
					File file = new File(realFilePath,saveFileName);
					System.out.println(file.getAbsolutePath());
					if (!file.exists()) {
						file.createNewFile();
					}
					OutputStream os = new FileOutputStream(file);
					//创建一个缓冲区
					byte[] buff = new byte[8192];
					int len = 0;
					while((len = is.read(buff)) != -1){
						os.write(buff, 0, len);
					}
					//关闭流
					is.close();
					os.close();
					//删除处理文件的临时文件
					fileItem.delete();
					System.out.println(otherFilePath);
					otherFilePath = "http://"+request.getLocalAddr()+":"+request.getLocalPort()+otherFilePath+File.separator+saveFileName;
//					for (int i = 0; i < otherFilePath.length(); i++) {
//						if (otherFilePath.charAt(i) == '\\') {
//							System.out.println(otherFilePath.charAt(i));
//						}
//					}
					otherFilePath =  otherFilePath.replace('\\', '/');
					System.out.println(otherFilePath);
					if(savaMyImgUrl(requestCode,otherFilePath,Integer.parseInt(id))){
						tag = 1;
						System.out.println("文件上传成功！");
					}else{
						tag = 0;
						file.delete(); 
						System.out.println("文件上传失败！");
					}

				}
			}
			System.out.println(id+":"+requestCode+":"+user_id);
		} catch (FileUploadException e) {
			e.printStackTrace();
			System.out.println("文件上传失败");
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件读写失败");
			e.printStackTrace();
		}
		return tag;
	}
	/**
	 * 产生唯一的文件名
	 * @param filename
	 * @return
	 */
	private static  String makeFileName(String filename){  //2.jpg
		//为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
//		return UUID.randomUUID().toString() + "_" + filename;
		int i = (int) (100000 + Math.random()*999999);
		return i+"_"+filename;
	}
	
	public static String makeTokenName(String user_name){  
		//为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + user_name;
	}
	

	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 *
	 * @param filename 文件名，要根据文件名生成存储目录
	 * @param savePath 文件存储路径
	 * @return 新的存储目录
	 */ 
	private static String makePath(String filename,String savePath){
		//得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;  //0--15
		int dir2 = (hashcode&0xf0)>>4;  //0-15
		//构造新的保存目录
		String dir = savePath + File.separator + dir1 + File.separator + dir2;  //upload\2\3  upload\3\5
		//File既可以代表文件也可以代表目录
		File file = new File(dir);
		//如果目录不存在
		if(!file.exists()){
			//创建目录
			file.mkdirs();
		}
		return dir;
	}

	private static boolean savaMyImgUrl(String requestCode,String url,Integer id){
		boolean bool = false;
		//user
		if (requestCode.equals("user")) {
			System.out.println("user");
			ImageBiz imageBiz = new ImageBizImpl();
			bool = imageBiz.addUserIcon(url, id);
		}
		//job
		if(requestCode.equals("job")){
			ImageBiz imageBiz = new ImageBizImpl();
			bool = imageBiz.addJobIcon(url, id);
		}
		//holiday
		
		if(requestCode.equals("holiday")){
			ImageBiz imageBiz = new ImageBizImpl();
			bool = imageBiz.addHolidayIcon(url, id);
		}
		//train
		if(requestCode.equals("train")){
			ImageBiz imageBiz = new ImageBizImpl();
			bool = imageBiz.addTrainIcon(url, id);
		}
		//talk
		if(requestCode.equals("talk")){
			ImageBiz imageBiz = new ImageBizImpl();
			bool = imageBiz.addTalkIcon(url, id);
		}
		return bool;

	}
	
	/**
	 * 得到要删除图片的真实路径
	 * @param request
	 * @param tempPath
	 * @return
	 */
	public static String getLocalImageUrl(String tempPath){
		String url = "";
		String[] strs = tempPath.split("/");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		url = Application.path+File.separator+strs[5]+File.separator+strs[6];
		System.out.println(url);
		return url;
	}


}
