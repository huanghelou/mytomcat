package com.tomcat.request;

import java.io.IOException;
import java.io.InputStream;

public class Request {

	private InputStream input;
	private String uri;
	
	public Request(InputStream input){
		this.input = input;
	}
	
	public void parse() throws IOException{
		
		StringBuffer request = new StringBuffer(2048);
		byte[] buffer = new byte[2048];
		while(input.read(buffer) != -1){
			request.append(new String(buffer));
		}
		System.out.println(request);
		uri = parseUri(request.toString());
	}

	/**
	 * 截取请求信息中2个空格之间的内容
	 * @param requestString
	 * @return
	 */
	private String parseUri(String requestString){
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1){
			index2 = requestString.indexOf(' ', index1 + 1);
			if(index2 > index1){				
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}
	
	public String getUri() {
		return uri;
	}
	
	
}
