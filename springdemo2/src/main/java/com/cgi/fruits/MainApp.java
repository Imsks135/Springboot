package com.cgi.fruits;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	        Fruit summerFruit = (Fruit) context.getBean("summerFruit");
	        Fruit winterFruit = (Fruit) context.getBean("winterFruit");
	        Fruit rainyFruit = (Fruit) context.getBean("rainyFruit");

	        System.out.println("Summer Fruit: " + summerFruit.getName());
	        System.out.println("Winter Fruit: " + winterFruit.getName());
	        System.out.println("Rainy Fruit: " + rainyFruit.getName());

	}

}
