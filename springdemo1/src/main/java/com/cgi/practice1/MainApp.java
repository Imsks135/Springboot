package com.cgi.practice1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		Product product1= context.getBean("product1", Product.class);
		Product product2= context.getBean("product2", Product.class);
		Product product3= context.getBean("product3", Product.class);
		Product product4= context.getBean("product4", Product.class);
		Product product5= context.getBean("product5", Product.class);
		
		System.out.println("Product 1: " + product1.getProductName() +  product1.getProductId());
	    System.out.println("Product 2: " + product2.getProductName() +  product2.getProductId());
	    System.out.println("Product 3: " + product3.getProductName() +  product3.getProductId());
        System.out.println("Product 4: " + product4.getProductName() +  product4.getProductId());
        System.out.println("Product 5: " + product5.getProductName() +  product5.getProductId());
       
	}

}
