package com.superhope.webservice;

import javax.jws.WebService;

@WebService(targetNamespace="http://service.demo.paybay.cn/",endpointInterface = "com.superhope.webservice.MyWebservice")
public class MyWebserviceImpl implements MyWebservice{

	@Override
	public String getUser( String a123 ) {
		// TODO Auto-generated method stub
		return a123;
	}

}
