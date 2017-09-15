package com.tomcat.request;

import java.io.IOException;
import java.io.InputStream;

public class Request {

	private InputStream input;
	private String uri;
	
	public Request(InputStream input){
		this.input = input;
	}
	
	public void parse() {
	    //从socket的InputStream中解析请求
	    StringBuffer request = new StringBuffer(2048);
	    int i;
	    byte[] buffer = new byte[2048];
	    try {
	      i = input.read(buffer);
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	      i = -1;
	    }
	    for (int j=0; j<i; j++) {
	      request.append((char) buffer[j]);
	    }
	    System.out.print(request.toString());
	    uri = parseUri(request.toString());
	  }

	/**
	 * 解析uri,解析出两个空格中间的内容
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
	
	/*
	   * 这种逻辑每次从请求中解析,会pending.不知道为什么,等学到后面了在解决这个问题
	   * public void parse() throws IOException{
			
			StringBuffer request = new StringBuffer(2048);
			byte[] buffer = new byte[2048];
			while(input.read(buffer) != -1){
				request.append(new String(buffer));
			}
			System.out.println(request);
			uri = parseUri(request.toString());
		}*/
}
