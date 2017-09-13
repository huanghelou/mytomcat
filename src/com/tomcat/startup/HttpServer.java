package com.tomcat.startup;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.tomcat.request.Request;
import com.tomcat.response.Response;

public class HttpServer {
	
	/**
	 * 静态资源存放目录
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
	
	private boolean shutdown = false;
	
	public void await(){
		ServerSocket serverSocket = null;
		int port = 9999;
		try {
			serverSocket = new ServerSocket(port, 0, InetAddress.getByName("127.0.0.1"));
		} catch (Exception e) {
			System.exit(1);
		}
		
		while(!shutdown){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				//创建请求对象
				Request request = new Request(input);
				request.parse();
				
				//创建响应对象
				Response response = new Response(request);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

}