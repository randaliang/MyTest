package com.superhope.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://service.demo.paybay.cn/")
public interface MyWebservice {
	@WebMethod
	public String getUser( String a );
}
