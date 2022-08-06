package com.mjstafford.fruityloops.models;

public class Item {
	
    // MEMBER VARIABLES
    private String name;
    private double price;
    
    // CONSTRUCTOR
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //DEPENDENCIES RELY ON GETTERS AND SETTERS TO EXIST
    //you can use thisItem.name instead of  thisItem.getName() in your JSP file, 
    //even if you have access set to private.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
