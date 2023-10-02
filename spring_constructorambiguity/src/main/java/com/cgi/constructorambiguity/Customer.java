package com.cgi.constructorambiguity;

public class Customer {
	
	private int id;
	private int price;
    private String itemname;

    public Customer(int price, String itemname) {   //first constructor
    	System.out.println("first constructor called");
        this.price = price;
        this.itemname = itemname;
    }
    public Customer(String itemname, int price) {   //second constructor
    	System.out.println("second constructor called");
        this.price= price;
        this.itemname = itemname;
    }

    public void showdetails() {
    	System.out.println(id);
    	System.out.println(price);
    	System.out.println(itemname);
    }
    
}
