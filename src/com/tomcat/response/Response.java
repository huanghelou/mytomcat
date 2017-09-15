package com.tomcat.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import com.tomcat.request.Request;
import com.tomcat.startup.HttpServer;

public class Response implements ServletResponse{
	
	private static final int BUFFER_SIZE = 1024;
	private OutputStream output;
	private Request request;
	
	/**
	 * 通过请求来给出响应,所以构造函数中传入Request
	 * @param request
	 */
	public Response(OutputStream output){
		this.output = output;
	}
	
	
	
	public void setRequest(Request request) {
		this.request = request;
	}



	public void sendStaticResource() throws IOException{

		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fileInputStream = null;
		
		try {
			
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			if(file.exists()){
				fileInputStream = new FileInputStream(file);
				int ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
				while(ch != -1){
					output.write(bytes, 0, BUFFER_SIZE);
					ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
				}
			}else{
				//如果找不到请求的资源,就返回错误信息
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
				          "Content-Type: text/html\r\n" +
				          "Content-Length: 23\r\n" +
				          "\r\n" +
				          "<h1>File Not Found</h1>";;
				output.write(errorMessage.getBytes());
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally{
			if(fileInputStream != null){
				fileInputStream.close();
			}
		}
		
	}



	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
