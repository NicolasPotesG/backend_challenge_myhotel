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

import com.challenge.vehicleapi.Vehicle;
import com.challenge.vehicleapi.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vehicle getVehicleById(@PathVariable Long id) {
		return vehicleService.getVehicleById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.createVehicle(vehicle);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
		return vehicleService.updateVehicle(id, vehicle);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteVehicle(@PathVariable Long id) {
		vehicleService.deleteVehicle(id);
	}

}
