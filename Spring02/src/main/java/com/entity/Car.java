package com.entity;

public class Car {

	private String brand;
	
	private String colour;
	
	private float displacement ;

	public Car() {
		super();
	}

	public Car(String brand, String colour, float displacement) {
		super();
		this.brand = brand;
		this.colour = colour;
		displacement = displacement;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public float getDisplacement() {
		return displacement;
	}

	public void setDisplacement(float displacement) {
		displacement = displacement;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", colour=" + colour + ", Displacement=" + displacement + "]";
	}
	
}
