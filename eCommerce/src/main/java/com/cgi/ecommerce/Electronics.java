package com.cgi.ecommerce;

public class Electronics implements Product {
	
	private String category;
	private double price;

	public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return null; // Electronics category doesn't have a brand
    }

    public String getModel() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }

}
