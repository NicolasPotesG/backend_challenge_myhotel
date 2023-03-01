package com.challenge.vehicleapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.vehicleapi.Maintenance;
import com.challenge.vehicleapi.Vehicle;
import com.challenge.vehicleapi.repository.MaintenanceRepository;
import com.challenge.vehicleapi.repository.VehicleRepository;

@Service
public class MaintenanceService {
	private final MaintenanceRepository maintenanceRepository;
	private final VehicleRepository vehicleRepository;

	public MaintenanceService(MaintenanceRepository maintenanceRepository, VehicleRepository vehicleRepository) {
		this.maintenanceRepository = maintenanceRepository;
		this.vehicleRepository = vehicleRepository;
	}

	public List<Maintenance> getAllMaintenanceRecordsForVehicle(Long vehicleId) {
		return maintenanceRepository.findByVehicleId(vehicleId);
	}

	public Maintenance createMaintenanceRecordForVehicle(Long vehicleId, Maintenance maintenance) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
		if (vehicle != null) {
			maintenance.setVehicleId(vehicleId);
			maintenance.setVehicle(vehicle);
			return maintenanceRepository.save(maintenance);
		}
		return null;
	}

	public Maintenance updateMaintenanceRecord(Long maintenanceId, Maintenance maintenanceRequest) {
		Maintenance maintenance = maintenanceRepository.findById(maintenanceId).orElse(null);
		if (maintenance != null) {
			maintenance.setDescription(maintenanceRequest.getDescription());
			maintenance.setDate(maintenanceRequest.getDate());
			return maintenanceRepository.save(maintenance);
		}
		return null;
	}

	public void deleteMaintenanceRecord(Long maintenanceId) {
		maintenanceRepository.deleteById(maintenanceId);
	}
}
