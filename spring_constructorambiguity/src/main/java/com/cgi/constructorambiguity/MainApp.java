package com.cgi.constructorambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Customer customer = (Customer) context.getBean("customer");
        
        System.out.println("Item details:");
        customer.showdetails();
	}

}
