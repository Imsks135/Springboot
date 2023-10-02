package com.cgi.springlist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer cust = (Customer) context.getBean("CustomerBean");
		System.out.println(cust);

	}

}
