package com.tomcat.startup;

import java.io.File;
import java.net.InetAddress;
import java.net.ServerSocket;

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
			// TODO: handle exception
		}
	}

}