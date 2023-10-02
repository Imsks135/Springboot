package com.cgi.ecommerce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Product smartphone = (Product) context.getBean("smartphone");
        Product laptop = (Product) context.getBean("laptop");
        Product electronics = (Product) context.getBean("electronics");

        System.out.println("Smartphone: " + smartphone.getBrand() + smartphone.getModel() + " Rs." + smartphone.getPrice());
        System.out.println("Laptop: " + laptop.getBrand() + laptop.getModel() + " Rs." + laptop.getPrice());
        System.out.println("Electronics Items: " + electronics.getModel() + " Rs." + electronics.getPrice());
	}

}
