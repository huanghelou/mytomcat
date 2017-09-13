package com.tomcat.startup;

import java.io.File;

public class HttpServer {
	
	/**
	 * 静态资源存放目录
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
	
	private boolean shutdown = false;
}
