package com.challenge.vehicleapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.vehicleapi.Maintenance;
import com.challenge.vehicleapi.service.MaintenanceService;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

	private final MaintenanceService maintenanceService;

	public MaintenanceController(MaintenanceService maintenanceService) {
		this.maintenanceService = maintenanceService;
	}

	@PostMapping("/vehicle/{vehicleId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Maintenance createMaintenanceRecordForVehicle(@PathVariable("vehicleId") Long vehicleId,
			@RequestBody Maintenance maintenance) {
		return maintenanceService.createMaintenanceRecordForVehicle(vehicleId, maintenance);
	}

	@PutMapping("/{maintenanceId}")
	@ResponseStatus(HttpStatus.OK)
	public Maintenance updateMaintenanceRecord(@PathVariable("maintenanceId") Long maintenanceId,
			@RequestBody Maintenance maintenanceRequest) {
		return maintenanceService.updateMaintenanceRecord(maintenanceId, maintenanceRequest);
	}

	@GetMapping("/vehicle/{vehicleId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Maintenance> getAllMaintenanceRecordsForVehicle(@PathVariable("vehicleId") Long vehicleId) {
		return maintenanceService.getAllMaintenanceRecordsForVehicle(vehicleId);
	}

	@DeleteMapping("/{maintenanceId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMaintenanceRecordById(@PathVariable("maintenanceId") Long maintenanceId) {
		maintenanceService.deleteMaintenanceRecord(maintenanceId);
	}

}
