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
	// ��װ�ϴ��ļ����͵ĳ�Ա����
	private String uploadContentType;
	// ��װ�ϴ��ļ���������
	private String uploadFileName;

	// json������������
	// 0 ��ʾ�ϴ�ʧ�ܣ�1 ��ʾ�ϴ��ɹ�
	private String success;
	// "��ʾ����Ϣ���ϴ��ɹ����ϴ�ʧ�ܼ�������Ϣ�ȡ�"
	private String message;
	// ͼƬ��ַ
	private String url;

	private ServletContext context;

	public String execute() throws Exception {
		if (upload == null) {
			setMessage("ͼƬ������");
			setSuccess("0");
			return Action.SUCCESS;
		}
		// �ϴ��ļ���
		String savePath = context.getRealPath("/upload");

		FileInputStream fis = new FileInputStream(upload);
		// �޸�����
		String filename = uploadFileName;
		int index = filename.lastIndexOf(".");
		String houzhui = filename.substring(index);
		String name = new Date().getTime() + houzhui;
		// ����·��
		String path = savePath + "\\" + name;
		FileOutputStream fos = new FileOutputStream(path);
		// �ļ�����ʱ����
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);

		}
		fos.flush();
		fis.close();
		fos.close();
		setMessage("�ϴ��ɹ�");
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
