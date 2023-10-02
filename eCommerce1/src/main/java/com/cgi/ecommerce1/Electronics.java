package com.cgi.ecommerce1;

public class Electronics implements Product {
	
	 private String category;
	 private double price;

	    public Electronics(String category, double price) {
	        this.category = category;
	        this.price = price;
	    }

	    public String getBrand() {
	        return null;
	    }

	    public String getModel() {
	        return category;
	    }

	    public double getPrice() {
	        return price;
	    }

}
