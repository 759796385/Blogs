package com.tq.ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;

public class UploadJson implements ServletContextAware {
	private File upload;
	// 封装上传文件类型的成员变量
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;

	// json返回三个参数
	// 0 表示上传失败，1 表示上传成功
	private String success;
	// "提示的信息，上传成功或上传失败及错误信息等。"
	private String message;
	// 图片地址
	private String url;

	private ServletContext context;

	public String execute() throws Exception {
		if (upload == null) {
			setMessage("图片不存在");
			setSuccess("0");
			return Action.SUCCESS;
		}
		// 上传文件夹
		String savePath = context.getRealPath("/upload");

		FileInputStream fis = new FileInputStream(upload);
		// 修改名字
		String filename = uploadFileName;
		int index = filename.lastIndexOf(".");
		String houzhui = filename.substring(index);
		String name = new Date().getTime() + houzhui;
		// 部署路径
		String path = savePath + "\\" + name;
		FileOutputStream fos = new FileOutputStream(path);
		// 文件名以时间名
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);

		}
		fos.flush();
		fis.close();
		fos.close();
		setMessage("上传成功");
		setSuccess("1");
		setUrl("upload/" + name);
		return Action.SUCCESS;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

}
