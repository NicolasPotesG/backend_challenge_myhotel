package com.challenge.vehicleapi;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle {
	private String type;
	private int tonsCapacity;
	private int numberOfAxles;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTonsCapacity() {
		return tonsCapacity;
	}

	public void setTonsCapacity(int tonsCapacity) {
		this.tonsCapacity = tonsCapacity;
	}

	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	public void setNumberOfAxles(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}
}
