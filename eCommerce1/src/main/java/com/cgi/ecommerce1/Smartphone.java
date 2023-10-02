package com.cgi.ecommerce1;

public class Smartphone implements Product {
	
	private String brand;
    private String model;
    private double price;

    public Smartphone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

}
