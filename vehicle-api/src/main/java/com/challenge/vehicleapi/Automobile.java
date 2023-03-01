package com.challenge.vehicleapi;

import jakarta.persistence.Entity;

@Entity
public class Automobile extends Vehicle {
	private String type;
	private int numberOfDoors;
	private int passengerCapacity;
	private int trunkCapacity;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public int getTrunkCapacity() {
		return trunkCapacity;
	}

	public void setTrunkCapacity(int trunkCapacity) {
		this.trunkCapacity = trunkCapacity;
	}

}
