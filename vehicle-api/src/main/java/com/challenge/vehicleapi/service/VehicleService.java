package com.challenge.vehicleapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.vehicleapi.Vehicle;
import com.challenge.vehicleapi.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	public Vehicle getVehicleById(Long id) {
		return vehicleRepository.findById(id).orElse(null);
	}

	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public Vehicle updateVehicle(Long id, Vehicle vehicle) {
		Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);
		if (existingVehicle != null) {
			existingVehicle.setBrand(vehicle.getBrand());
			existingVehicle.setModel(vehicle.getModel());
			existingVehicle.setPatent(vehicle.getPatent());
			existingVehicle.setYear(vehicle.getYear());
			existingVehicle.setKilometrage(vehicle.getKilometrage());
			existingVehicle.setEngineDisplacement(vehicle.getEngineDisplacement());
			vehicleRepository.save(existingVehicle);
		}
		return existingVehicle;
	}

	public void deleteVehicle(Long id) {
		vehicleRepository.deleteById(id);
	}

}
