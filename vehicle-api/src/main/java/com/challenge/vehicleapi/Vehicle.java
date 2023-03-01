package com.challenge.vehicleapi;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String brand;
	private String model;
	private String patent;
	private int year;
	private int kilometrage;
	private int engineDisplacement;

	@OneToMany(mappedBy = "vehicle")
	private List<Maintenance> maintenanceList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPatent() {
		return patent;
	}

	public void setPatent(String patent) {
		this.patent = patent;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public int getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public List<Maintenance> getMaintenanceList() {
		return maintenanceList;
	}

	public void setMaintenanceList(List<Maintenance> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}

}
