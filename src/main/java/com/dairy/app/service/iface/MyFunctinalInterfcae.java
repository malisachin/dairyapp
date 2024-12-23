package com.dairy.app.service.iface;

public interface MyFunctinalInterfcae {

	void excuate();
	
	public default String getPrintStatement() {
		System.out.println("Hello form  default method");
		return "Hello form  default method";
	}
}
